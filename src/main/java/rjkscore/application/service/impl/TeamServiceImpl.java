package rjkscore.application.service.impl;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

import rjkscore.application.service.TeamService;
import rjkscore.infrastructure.Client.PandaScoreApiClient;

@Service
public class TeamServiceImpl implements TeamService {

    private final PandaScoreApiClient pandaScoreApiClient;

    public TeamServiceImpl(PandaScoreApiClient pandaScoreApiClient) {
        this.pandaScoreApiClient = pandaScoreApiClient;
    }

    @Override
    public JsonNode getTeams() {
        return pandaScoreApiClient.getTeams();
    }

    @Override
    public JsonNode getTeam(String teamIdOrSlug) {
        return pandaScoreApiClient.getTeam(teamIdOrSlug);
    }

    @Override
    public JsonNode getTeamLeagues(String teamIdOrSlug) {
        return pandaScoreApiClient.getTeamLeagues(teamIdOrSlug);
    }

    @Override
    public JsonNode getTeamMatches(String teamIdOrSlug) {
        return pandaScoreApiClient.getTeamMatches(teamIdOrSlug);
    }

    @Override
    public JsonNode getTeamTournaments(String teamIdOrSlug) {
        return pandaScoreApiClient.getTeamTournaments(teamIdOrSlug);
    }
}
