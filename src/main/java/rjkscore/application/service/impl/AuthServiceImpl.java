package rjkscore.application.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rjkscore.Domain.AppUser;
import rjkscore.application.mapper.AppUserMapper;
import rjkscore.application.service.AuthService;
import rjkscore.configuration.JwtUtil;
import rjkscore.infrastructure.Dto.Request.LoginRequestDto;
import rjkscore.infrastructure.Dto.Request.RegisterRequestDto;
import rjkscore.infrastructure.Dto.Response.AuthResponseDto;
import rjkscore.infrastructure.Repository.AppUserRepository;

@Service
public class AuthServiceImpl implements AuthService {
     private final AppUserRepository appUserRepository;
    private final AppUserMapper appUserMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(AppUserRepository appUserRepository, AppUserMapper appUserMapper, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.appUserRepository = appUserRepository;
        this.appUserMapper = appUserMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public AuthResponseDto register(RegisterRequestDto dto) {
        if (appUserRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email ya registrado");
        }
        if (appUserRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Usuario ya registrado");
        }
        String hashedPassword = passwordEncoder.encode(dto.getPassword());
        AppUser newUser = appUserMapper.toEntity(dto, hashedPassword);
        appUserRepository.save(newUser);

        User springUser = new User(newUser.getUsername(), newUser.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
        String token = jwtUtil.generateToken(springUser);

        AuthResponseDto response = new AuthResponseDto();
        response.setToken(token);
        response.setUser(appUserMapper.toResponseDto(newUser));
        response.setMessage("Usuario registrado correctamente");
        return response;
    }

    @Override
    public AuthResponseDto login(LoginRequestDto dto) {
        Optional<AppUser> userOpt = appUserRepository.findByUsername(dto.getUsernameOrEmail());
        if (userOpt.isEmpty()) {
            userOpt = appUserRepository.findByEmail(dto.getUsernameOrEmail());
            if (userOpt.isEmpty()) throw new RuntimeException("Usuario no encontrado");
        }
        AppUser user = userOpt.get();

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        User springUser = new User(user.getUsername(), user.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
        String token = jwtUtil.generateToken(springUser);

        AuthResponseDto response = new AuthResponseDto();
        response.setToken(token);
        response.setUser(appUserMapper.toResponseDto(user));
        response.setMessage("Login correcto");
        return response;
    }

}
