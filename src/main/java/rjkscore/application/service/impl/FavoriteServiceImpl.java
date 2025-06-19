package rjkscore.application.service.impl;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                    case "dota2_team" -> itemData = pandaScoreApiClient.getDota2Team(id);
                    case "dota2_player" -> itemData = pandaScoreApiClient.getDota2Player(id);
                    case "dota2_tournament" -> itemData = pandaScoreApiClient.getDota2Tournament(id);
                    case "dota2_match" -> itemData = pandaScoreApiClient.getDota2Match(id);
                    case "dota2_game" -> itemData = pandaScoreApiClient.getDota2Game(id);
                    case "lol_team" -> itemData = pandaScoreApiClient.getLolTeam(id);
                    case "lol_player" -> itemData = pandaScoreApiClient.getLolPlayer(id);
                    case "lol_match" -> itemData = pandaScoreApiClient.getLolMatch(id);
                    case "lol_tournament" -> itemData = pandaScoreApiClient.getLolTournament(id);
                    case "lol_champion" -> itemData = pandaScoreApiClient.getLolChampion(id);
                    case "lol_item" -> itemData = pandaScoreApiClient.getLolItem(id);
                    case "lol_mastery" -> itemData = pandaScoreApiClient.getLolMastery(id);
                    case "lol_spell" -> itemData = pandaScoreApiClient.getLolSpell(id);
                    case "lol_rune" -> itemData = pandaScoreApiClient.getLolRuneReforged(id);
                    case "lol_rune_path" -> itemData = pandaScoreApiClient.getLolRunesReforgedPath(id);
                    case "valorant_ability" -> itemData = pandaScoreApiClient.getValorantAbility(id);
                    case "valorant_agent" -> itemData = pandaScoreApiClient.getValorantAgent(id);
                    case "valorant_map" -> itemData = pandaScoreApiClient.getValorantMap(id);
                    case "valorant_match" -> itemData = pandaScoreApiClient.getValorantMatches();
                    case "valorant_player" -> itemData = pandaScoreApiClient.getValorantPlayers();
                    case "valorant_series" -> itemData = pandaScoreApiClient.getValorantSeries();
                    case "valorant_team" -> itemData = pandaScoreApiClient.getValorantTeams();
                    case "valorant_tournament" -> itemData = pandaScoreApiClient.getValorantTournaments();
                    case "valorant_weapon" -> itemData = pandaScoreApiClient.getValorantWeapon(id);
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

    @Override
    @Transactional
    public void removeAllFavorites(String username) {
        AppUser user = appUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        favoriteRepository.deleteByUser(user);
    }
}
