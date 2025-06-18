package rjkscore.application.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface ValorantService {
    // Abilities
    JsonNode getAbilities();
    JsonNode getAbility(String abilityId);

    // Agents
    JsonNode getAgents();
    JsonNode getAgent(String agentId);

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

    // Players
    JsonNode getPlayers();

    // Series
    JsonNode getSeries();
    JsonNode getSeriesPast();
    JsonNode getSeriesRunning();
    JsonNode getSeriesUpcoming();

    // Teams
    JsonNode getTeams();

    // Tournaments
    JsonNode getTournaments();
    JsonNode getTournamentsPast();
    JsonNode getTournamentsRunning();
    JsonNode getTournamentsUpcoming();

    // Weapons
    JsonNode getWeapons();
    JsonNode getWeapon(String weaponId);
}
