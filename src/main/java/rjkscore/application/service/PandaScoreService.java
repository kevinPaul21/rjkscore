package rjkscore.application.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface PandaScoreService {
    JsonNode getTeams();
    JsonNode getPlayers();
    JsonNode getMatches();
}
