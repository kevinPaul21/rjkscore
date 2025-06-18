package rjkscore.application.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface LolService {
    // Champions
    JsonNode getChampions();
    JsonNode getChampion(String championId);

    // Items
    JsonNode getItems();
    JsonNode getItem(String itemId);

    // Leagues
    JsonNode getLeagues();

    // Masteries
    JsonNode getMasteries();
    JsonNode getMastery(String masteryId);

    // Matches
    JsonNode getMatches();
    JsonNode getMatchesPast();
    JsonNode getMatchesRunning();
    JsonNode getMatchesUpcoming();
    JsonNode getMatch(String matchId);

    // Players
    JsonNode getPlayers();
    JsonNode getPlayer(String playerId);

    // Runes
    JsonNode getRunesReforged();
    JsonNode getRunesReforgedPaths();
    JsonNode getRunesReforgedPath(String pathId);
    JsonNode getRuneReforged(String runeId);

    // Series
    JsonNode getSeries();
    JsonNode getSeriesPast();
    JsonNode getSeriesRunning();
    JsonNode getSeriesUpcoming();
    JsonNode getSeriesTeams(String seriesId);

    // Teams
    JsonNode getTeams();
    JsonNode getTeam(String teamId);

    // Spells
    JsonNode getSpells();
    JsonNode getSpell(String spellId);

    // Tournaments
    JsonNode getTournaments();
    JsonNode getTournament(String tournamentId);
    JsonNode getTournamentsPast();
    JsonNode getTournamentsRunning();
    JsonNode getTournamentsUpcoming();
}
