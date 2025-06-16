package rjkscore.application.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface TeamService {
    JsonNode getTeams();
    JsonNode getTeam(String teamIdOrSlug);
    JsonNode getTeamLeagues(String teamIdOrSlug);
    JsonNode getTeamMatches(String teamIdOrSlug);
    JsonNode getTeamTournaments(String teamIdOrSlug);
}
