package rjkscore.application.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface PlayerService {
    JsonNode getPlayers();
    JsonNode getPlayer(String playerIdOrSlug);
    JsonNode getPlayerLeagues(String playerIdOrSlug);
    JsonNode getPlayerMatches(String playerIdOrSlug);
    JsonNode getPlayerSeries(String playerIdOrSlug);
    JsonNode getPlayerTournaments(String playerIdOrSlug);
}
