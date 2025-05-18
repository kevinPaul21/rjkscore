package rjkscore.application.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

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

    public AppUserServiceImpl(AppUserRepository repository, AppUserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
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

    @Override
    public AppUserResponseDto updateUser(Long userId, UpdateUserDto dto) {
        AppUser user = repository.findById(userId)
              .orElseThrow(()-> new NoSuchElementException("user not found"));
            user.setUsername(dto.getUsername());
            user.setEmail(dto.getEmail());

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
