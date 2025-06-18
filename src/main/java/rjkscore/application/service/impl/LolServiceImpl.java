package rjkscore.application.service.impl;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import rjkscore.application.service.LolService;
import rjkscore.infrastructure.Client.PandaScoreApiClient;

@Service
public class LolServiceImpl implements LolService {

    private final PandaScoreApiClient pandaScoreApiClient;

    public LolServiceImpl(PandaScoreApiClient pandaScoreApiClient) {
        this.pandaScoreApiClient = pandaScoreApiClient;
    }

    // Champions
    @Override
    public JsonNode getChampions() {
        return pandaScoreApiClient.getLolChampions();
    }

    @Override
    public JsonNode getChampion(String championId) {
        return pandaScoreApiClient.getLolChampion(championId);
    }

    // Items
    @Override
    public JsonNode getItems() {
        return pandaScoreApiClient.getLolItems();
    }

    @Override
    public JsonNode getItem(String itemId) {
        return pandaScoreApiClient.getLolItem(itemId);
    }

    // Leagues
    @Override
    public JsonNode getLeagues() {
        return pandaScoreApiClient.getLolLeagues();
    }

    // Masteries
    @Override
    public JsonNode getMasteries() {
        return pandaScoreApiClient.getLolMasteries();
    }

    @Override
    public JsonNode getMastery(String masteryId) {
        return pandaScoreApiClient.getLolMastery(masteryId);
    }

    // Matches
    @Override
    public JsonNode getMatches() {
        return pandaScoreApiClient.getLolMatches();
    }

    @Override
    public JsonNode getMatchesPast() {
        return pandaScoreApiClient.getLolMatchesPast();
    }

    @Override
    public JsonNode getMatchesRunning() {
        return pandaScoreApiClient.getLolMatchesRunning();
    }

    @Override
    public JsonNode getMatchesUpcoming() {
        return pandaScoreApiClient.getLolMatchesUpcoming();
    }

    @Override
    public JsonNode getMatch(String matchId) {
        return pandaScoreApiClient.getLolMatch(matchId);
    }

    // Players
    @Override
    public JsonNode getPlayers() {
        return pandaScoreApiClient.getLolPlayers();
    }

    @Override
    public JsonNode getPlayer(String playerId) {
        return pandaScoreApiClient.getLolPlayer(playerId);
    }

    // Runes
    @Override
    public JsonNode getRunesReforged() {
        return pandaScoreApiClient.getLolRunesReforged();
    }

    @Override
    public JsonNode getRunesReforgedPaths() {
        return pandaScoreApiClient.getLolRunesReforgedPaths();
    }

    @Override
    public JsonNode getRunesReforgedPath(String pathId) {
        return pandaScoreApiClient.getLolRunesReforgedPath(pathId);
    }

    @Override
    public JsonNode getRuneReforged(String runeId) {
        return pandaScoreApiClient.getLolRuneReforged(runeId);
    }

    // Series
    @Override
    public JsonNode getSeries() {
        return pandaScoreApiClient.getLolSeries();
    }

    @Override
    public JsonNode getSeriesPast() {
        return pandaScoreApiClient.getLolSeriesPast();
    }

    @Override
    public JsonNode getSeriesRunning() {
        return pandaScoreApiClient.getLolSeriesRunning();
    }

    @Override
    public JsonNode getSeriesUpcoming() {
        return pandaScoreApiClient.getLolSeriesUpcoming();
    }

    @Override
    public JsonNode getSeriesTeams(String seriesId) {
        return pandaScoreApiClient.getLolSeriesTeams(seriesId);
    }

    // Teams
    @Override
    public JsonNode getTeams() {
        return pandaScoreApiClient.getLolTeams();
    }

    @Override
    public JsonNode getTeam(String teamId) {
        return pandaScoreApiClient.getLolTeam(teamId);
    }

    // Spells
    @Override
    public JsonNode getSpells() {
        return pandaScoreApiClient.getLolSpells();
    }

    @Override
    public JsonNode getSpell(String spellId) {
        return pandaScoreApiClient.getLolSpell(spellId);
    }

    // Tournaments
    @Override
    public JsonNode getTournaments() {
        return pandaScoreApiClient.getLolTournaments();
    }

    @Override
    public JsonNode getTournament(String tournamentId) {
        return pandaScoreApiClient.getLolTournament(tournamentId);
    }

    @Override
    public JsonNode getTournamentsPast() {
        return pandaScoreApiClient.getLolTournamentsPast();
    }

    @Override
    public JsonNode getTournamentsRunning() {
        return pandaScoreApiClient.getLolTournamentsRunning();
    }

    @Override
    public JsonNode getTournamentsUpcoming() {
        return pandaScoreApiClient.getLolTournamentsUpcoming();
    }
}
