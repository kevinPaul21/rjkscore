package rjkscore.application.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import rjkscore.Domain.AppUser;
import rjkscore.application.mapper.FavoriteMapper;
import rjkscore.application.service.FavoriteService;
import rjkscore.infrastructure.Dto.Request.FavoriteRequestDto;
import rjkscore.infrastructure.Dto.Response.FavoriteResponseDto;
import rjkscore.infrastructure.Repository.AppUserRepository;
import rjkscore.infrastructure.Repository.FavoriteRepository;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final AppUserRepository appUserRepository;
    private final FavoriteMapper favoriteMapper;

    public FavoriteServiceImpl(FavoriteRepository favoriteRepository,
                               AppUserRepository appUserRepository,
                               FavoriteMapper favoriteMapper) {
        this.favoriteRepository = favoriteRepository;
        this.appUserRepository = appUserRepository;
        this.favoriteMapper = favoriteMapper;
    }

    @Override
    public FavoriteResponseDto addFavorite(String username, FavoriteRequestDto dto) {
        AppUser user = appUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        var favorite = favoriteRepository.save(favoriteMapper.toEntity(dto, user));
        return favoriteMapper.toResponseDto(favorite);
    }

    @Override
    public List<FavoriteResponseDto> getFavorites(String username) {
        AppUser user = appUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return favoriteRepository.findByUser(user).stream()
                .map(favoriteMapper::toResponseDto)
                .toList();
    }

    @Override
    public void removeFavorite(Integer favoriteId, String username) {
        AppUser user = appUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        var favorite = favoriteRepository.findById(favoriteId)
                .orElseThrow(() -> new RuntimeException("Favorite not found"));
        if (!favorite.getUser().getUserId().equals(user.getUserId())) {
            throw new RuntimeException("Favorite does not belong to user");
        }
        favoriteRepository.delete(favorite);
    }
}
