package rjkscore.application.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rjkscore.Domain.AppUser;
import rjkscore.application.mapper.AppUserMapper;
import rjkscore.application.service.AppUserService;
import rjkscore.infrastructure.Dto.Request.UpdateUserDto;
import rjkscore.infrastructure.Dto.Response.AppUserResponseDto;
import rjkscore.infrastructure.Repository.AppUserRepository;

@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository repository;
    private final AppUserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public AppUserServiceImpl(AppUserRepository repository, AppUserMapper mapper,
                              PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<AppUserResponseDto> getAllUsers(){
        return repository.findAll().stream()
            .map(mapper::toResponseDto)
            .toList();
    }

    @Override
    public AppUserResponseDto getUserById(Long userId) {
        return repository.findById(userId)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private void validateAndSetUserFields(AppUser user, UpdateUserDto dto) {
        if (dto.getUsername() != null) {
            repository.findByUsername(dto.getUsername())
                .filter(u -> !u.getUserId().equals(user.getUserId()))
                .ifPresent(u -> { throw new RuntimeException("Username already exists"); });
            user.setUsername(dto.getUsername());
        }

        if (dto.getEmail() != null) {
            repository.findByEmail(dto.getEmail())
                .filter(u -> !u.getUserId().equals(user.getUserId()))
                .ifPresent(u -> { throw new RuntimeException("Email already exists"); });
            user.setEmail(dto.getEmail());
        }

        if (dto.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
    }

    @Override
    public AppUserResponseDto updateUser(Long userId, UpdateUserDto dto) {
        AppUser user = repository.findById(userId)
            .orElseThrow(() -> new NoSuchElementException("User not found"));
        validateAndSetUserFields(user, dto);
        return mapper.toResponseDto(repository.save(user));
    }

    @Override
    public AppUserResponseDto updateUser(String username, UpdateUserDto dto) {
        AppUser user = repository.findByUsername(username)
            .orElseThrow(() -> new NoSuchElementException("User not found"));
        validateAndSetUserFields(user, dto);
        return mapper.toResponseDto(repository.save(user));
    }

    @Override
    public AppUserResponseDto updateCoins(Long userId, int newCoins) {
        AppUser user = repository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("user not found"));
        user.setCoins(newCoins);
        return mapper.toResponseDto(repository.save(user));
    }
}
