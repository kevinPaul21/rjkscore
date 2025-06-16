package rjkscore.application.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface PandaScoreService {
    JsonNode getTeams();
    JsonNode getPlayers();
    JsonNode getMatches();
    JsonNode getLeagues();
    JsonNode getLeague(String league);
    JsonNode getLeagueTournaments(String league);
    JsonNode getLeagueSeries(String league);
    JsonNode getLeagueMatchesUpcoming(String league);
    JsonNode getLeagueMatchesRunning(String league);
    JsonNode getLeagueMatchesPast(String league);
    JsonNode getLeagueMatches(String league);
}
