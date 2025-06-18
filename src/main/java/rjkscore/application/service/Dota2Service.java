package rjkscore.application.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface Dota2Service {
    // Abilities
    JsonNode getAbilities();
    JsonNode getAbility(String abilityId);

    // Games
    JsonNode getGame(String gameId);

    // Heroes
    JsonNode getHeroes();
    JsonNode getHero(String heroId);

    // Items
    JsonNode getItems();
    JsonNode getItem(String itemId);

    // Leagues
    JsonNode getLeagues();

    // Matches
    JsonNode getMatches();
    JsonNode getMatchesPast();
    JsonNode getMatchesRunning();
    JsonNode getMatchesUpcoming();
    JsonNode getMatch(String matchId);

    // Players
    JsonNode getPlayers();
    JsonNode getPlayer(String playerId);

    // Series
    JsonNode getSeries();
    JsonNode getSeriesPast();
    JsonNode getSeriesRunning();
    JsonNode getSeriesUpcoming();
    JsonNode getSeriesTeams(String seriesId);

    // Teams
    JsonNode getTeams();
    JsonNode getTeam(String teamId);

    // Tournaments
    JsonNode getTournaments();
    JsonNode getTournamentsPast();
    JsonNode getTournamentsRunning();
    JsonNode getTournamentsUpcoming();
    JsonNode getTournament(String tournamentId);
}
