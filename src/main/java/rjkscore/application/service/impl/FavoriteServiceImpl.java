package rjkscore.application.service.impl;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

import rjkscore.Domain.AppUser;
import rjkscore.application.mapper.FavoriteMapper;
import rjkscore.application.service.FavoriteService;
import rjkscore.infrastructure.Client.PandaScoreApiClient;
import rjkscore.infrastructure.Dto.Request.FavoriteRequestDto;
import rjkscore.infrastructure.Dto.Response.FavoriteResponseDto;
import rjkscore.infrastructure.Repository.AppUserRepository;
import rjkscore.infrastructure.Repository.FavoriteRepository;
import rjkscore.infrastructure.Client.PandaScoreApiClient;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final AppUserRepository appUserRepository;
    private final FavoriteMapper favoriteMapper;
    private final PandaScoreApiClient pandaScoreApiClient;


   public FavoriteServiceImpl(FavoriteRepository favoriteRepository,
                           AppUserRepository appUserRepository,
                           FavoriteMapper favoriteMapper,
                           PandaScoreApiClient pandaScoreApiClient) {
    this.favoriteRepository = favoriteRepository;
    this.appUserRepository = appUserRepository;
    this.favoriteMapper = favoriteMapper;
    this.pandaScoreApiClient = pandaScoreApiClient;
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
            .map(fav -> {
                FavoriteResponseDto dto = favoriteMapper.toResponseDto(fav);

                // Obtener datos de PandaScore según el tipo
                String id = String.valueOf(fav.getItemId());
                String type = fav.getItemType().toLowerCase();
                JsonNode itemData = null;

                switch (type) {
                    case "team" -> itemData = pandaScoreApiClient.getTeam(id);
                    case "player" -> itemData = pandaScoreApiClient.getPlayer(id);
                    case "match" -> itemData = pandaScoreApiClient.getMatch(id);
                    case "tournament" -> itemData = pandaScoreApiClient.getLeague(id);
                    case "videogame" -> itemData = pandaScoreApiClient.getVideogame(id);
                    case "csgo_team" -> itemData = pandaScoreApiClient.getCsgoTeam(id);
                    case "csgo_player" -> itemData = pandaScoreApiClient.getCsgoPlayer(id);
                    case "csgo_tournament" -> itemData = pandaScoreApiClient.getCsgoTournament(id);
                    case "csgo_match" -> itemData = pandaScoreApiClient.getCsgoMatch(id);
                    case "csgo_game" -> itemData = pandaScoreApiClient.getCsgoGame(id);
                    case "csgo_map" -> itemData = pandaScoreApiClient.getCsgoMap(id);
                    case "csgo_weapon" -> itemData = pandaScoreApiClient.getCsgoWeapon(id);
                    case "series" -> itemData = pandaScoreApiClient.getSeries(id);

                    default -> itemData = null;
                }

                dto.setItemData(itemData);
                return dto;
            })
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
