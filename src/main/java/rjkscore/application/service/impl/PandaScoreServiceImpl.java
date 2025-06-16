package rjkscore.application.service.impl;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

import rjkscore.application.service.PandaScoreService;
import rjkscore.infrastructure.Client.PandaScoreApiClient;

@Service
public class PandaScoreServiceImpl implements PandaScoreService {

    private final PandaScoreApiClient pandaScoreApiClient;

    public PandaScoreServiceImpl(PandaScoreApiClient pandaScoreApiClient) {
        this.pandaScoreApiClient = pandaScoreApiClient;
    }

    @Override
    public JsonNode getTeams() {
        return pandaScoreApiClient.getTeams();
    }

    @Override
    public JsonNode getPlayers() {
        return pandaScoreApiClient.getPlayers();
    }

    @Override
    public JsonNode getMatches() {
        return pandaScoreApiClient.getMatches();
    }
}
