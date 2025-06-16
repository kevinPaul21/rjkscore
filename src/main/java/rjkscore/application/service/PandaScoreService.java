package rjkscore.application.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface PandaScoreService {
    JsonNode getTeams();
    JsonNode getPlayers();
    JsonNode getMatches();
    JsonNode getMatchesPast();
    JsonNode getMatchesRunning();
    JsonNode getMatchesUpcoming();
    JsonNode getMatch(String matchIdOrSlug);
    JsonNode getMatchOpponents(String matchIdOrSlug);
    JsonNode getLeagues();
    JsonNode getLeague(String league);
    JsonNode getLeagueTournaments(String league);
    JsonNode getLeagueSeries(String league);
    JsonNode getLeagueMatchesUpcoming(String league);
    JsonNode getLeagueMatchesRunning(String league);
    JsonNode getLeagueMatchesPast(String league);
    JsonNode getLeagueMatches(String league);
    JsonNode getVideogames();
    JsonNode getVideogame(String videogameIdOrSlug);
    JsonNode getVideogameLeagues(String videogameIdOrSlug);
    JsonNode getVideogameSeries(String videogameIdOrSlug);
    JsonNode getVideogameTitles(String videogameIdOrSlug);
    JsonNode getVideogameTournaments(String videogameIdOrSlug);
    JsonNode getVideogameVersions(String videogameIdOrSlug);
}
