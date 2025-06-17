package rjkscore.application.mapper;

import org.springframework.stereotype.Component;

import rjkscore.Domain.AppUser;
import rjkscore.Domain.Favorite;
import rjkscore.infrastructure.Dto.Request.FavoriteRequestDto;
import rjkscore.infrastructure.Dto.Response.FavoriteResponseDto;

@Component
public class FavoriteMapper {
    public Favorite toEntity(FavoriteRequestDto dto, AppUser user) {
        return Favorite.builder()
                .user(user)
                .itemType(dto.getItemType())
                .itemId(dto.getItemId())
                .build();
    }

    public FavoriteResponseDto toResponseDto(Favorite favorite) {
        FavoriteResponseDto dto = new FavoriteResponseDto();
        dto.setFavoriteId(favorite.getFavoriteId());
        dto.setItemType(favorite.getItemType());
        dto.setItemId(favorite.getItemId());
        dto.setCreatedAt(favorite.getCreatedAt());
        return dto;
    }
}
