package rjkscore.application.service.impl;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;

import rjkscore.application.service.PlayerService;
import rjkscore.infrastructure.Client.PandaScoreApiClient;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PandaScoreApiClient pandaScoreApiClient;

    public PlayerServiceImpl(PandaScoreApiClient pandaScoreApiClient) {
        this.pandaScoreApiClient = pandaScoreApiClient;
    }

    @Override
    public JsonNode getPlayers() {
        return pandaScoreApiClient.getPlayers();
    }

    @Override
    public JsonNode getPlayer(String playerIdOrSlug) {
        return pandaScoreApiClient.getPlayer(playerIdOrSlug);
    }

    @Override
    public JsonNode getPlayerLeagues(String playerIdOrSlug) {
        return pandaScoreApiClient.getPlayerLeagues(playerIdOrSlug);
    }

    @Override
    public JsonNode getPlayerMatches(String playerIdOrSlug) {
        return pandaScoreApiClient.getPlayerMatches(playerIdOrSlug);
    }

    @Override
    public JsonNode getPlayerSeries(String playerIdOrSlug) {
        return pandaScoreApiClient.getPlayerSeries(playerIdOrSlug);
    }

    @Override
    public JsonNode getPlayerTournaments(String playerIdOrSlug) {
        return pandaScoreApiClient.getPlayerTournaments(playerIdOrSlug);
    }
}
