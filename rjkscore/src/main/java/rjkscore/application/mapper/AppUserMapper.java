package rjkscore.application.mapper;

import org.springframework.stereotype.Component;

import rjkscore.Domain.AppUser;
import rjkscore.infrastructure.Dto.Request.AppUserRequestDto;
import rjkscore.infrastructure.Dto.Request.RegisterRequestDto;
import rjkscore.infrastructure.Dto.Request.UpdateUserDto;
import rjkscore.infrastructure.Dto.Response.AppUserResponseDto;

@Component
public class AppUserMapper {
    public AppUserResponseDto toResponseDto(AppUser user) {
        if (user == null)
            return null;

        return AppUserResponseDto.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .email(user.getEmail())
                .coins(user.getCoins())
                .build();
    }

    public AppUser toEntity(AppUserRequestDto dto, String hashedPassword) {
        if (dto == null)
            return null;

        return AppUser.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(hashedPassword)
                .coins(1000)
                .build();
    }

    public AppUser toEntity(RegisterRequestDto dto, String hashedPassword) {
        if (dto == null)
            return null;

        return AppUser.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(hashedPassword)
                .coins(1000)
                .build();
    }

    public void updateFromDto (AppUser user, UpdateUserDto dto){
        if(dto.getUsername() != null)user.setUsername(dto.getUsername()); 
        if(dto.getEmail() != null)user.setEmail(dto.getEmail()); 

    }
}
