package rjkscore.application.service;

import java.util.List;

import rjkscore.infrastructure.Dto.Request.UpdateUserDto;
import rjkscore.infrastructure.Dto.Response.AppUserResponseDto;

public interface AppUserService {
    List<AppUserResponseDto> getAllUsers();

    AppUserResponseDto getUserById(Long userId);

    AppUserResponseDto updateUser(Long userId, UpdateUserDto dto);

    AppUserResponseDto updateUser(String username, UpdateUserDto dto);
    AppUserResponseDto updateCoins(Long userId, int newCoins); 
}