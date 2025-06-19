package rjkscore.application.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface CsgoService {
    // Games
    JsonNode getGames();
    JsonNode getGame(String gameId);
    JsonNode getGameEvents(String gameId);
    JsonNode getGameRounds(String gameId);

    // Leagues
    JsonNode getLeagues();

    // Maps
    JsonNode getMaps();
    JsonNode getMap(String mapId);

    // Matches
    JsonNode getMatches();
    JsonNode getMatchesPast();
    JsonNode getMatchesRunning();
    JsonNode getMatchesUpcoming();
    JsonNode getMatch(String matchId);

    // Stats
    JsonNode getPlayerStats();
    JsonNode getTeamStats();
    JsonNode getTournamentStats();

    // Players
    JsonNode getPlayers();
    JsonNode getPlayer(String playerId);

    // Series
    JsonNode getSeries();

    // Teams
    JsonNode getTeams();
    JsonNode getTeam(String teamId);

    // Tournaments
    JsonNode getTournaments();
    JsonNode getTournamentsPast();
    JsonNode getTournamentsRunning();
    JsonNode getTournamentsUpcoming();
    JsonNode getTournament(String tournamentId);

    // Weapons
    JsonNode getWeapons();
    JsonNode getWeapon(String weaponId);
}
