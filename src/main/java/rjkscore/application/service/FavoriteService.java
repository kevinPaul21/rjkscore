package rjkscore.application.service;

import java.util.List;

import rjkscore.infrastructure.Dto.Request.FavoriteRequestDto;
import rjkscore.infrastructure.Dto.Response.FavoriteResponseDto;

public interface FavoriteService {
    FavoriteResponseDto addFavorite(String username, FavoriteRequestDto dto);
    List<FavoriteResponseDto> getFavorites(String username);
    void removeFavorite(Integer favoriteId, String username);
}
