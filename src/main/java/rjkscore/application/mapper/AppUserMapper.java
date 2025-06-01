package rjkscore.application.mapper;

import org.springframework.stereotype.Component;

import rjkscore.Domain.AppUser;
import rjkscore.infrastructure.Dto.Request.RegisterRequestDto;
import rjkscore.infrastructure.Dto.Response.AppUserResponseDto;

@Component
public class AppUserMapper {
     public AppUser toEntity(RegisterRequestDto dto, String hashedPassword) {
        return AppUser.builder()
            .username(dto.getUsername())
            .email(dto.getEmail())
            .password(hashedPassword)
            .coins(100)
            .roles("USER")
            .build();
    }

    public AppUserResponseDto toResponseDto(AppUser user) {
        return AppUserResponseDto.builder()
            .userId(user.getUserId())
            .username(user.getUsername())
            .email(user.getEmail())
            .coins(user.getCoins())
            .roles(user.getRoles())
            .build();
    }
}
