package rjkscore.application.service.impl;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

import rjkscore.application.service.Dota2Service;
import rjkscore.infrastructure.Client.PandaScoreApiClient;

@Service
public class Dota2ServiceImpl implements Dota2Service {

    private final PandaScoreApiClient pandaScoreApiClient;

    public Dota2ServiceImpl(PandaScoreApiClient pandaScoreApiClient) {
        this.pandaScoreApiClient = pandaScoreApiClient;
    }

    // Abilities
    @Override
    public JsonNode getAbilities() {
        return pandaScoreApiClient.getDota2Abilities();
    }

    @Override
    public JsonNode getAbility(String abilityId) {
        return pandaScoreApiClient.getDota2Ability(abilityId);
    }

    // Games
    @Override
    public JsonNode getGame(String gameId) {
        return pandaScoreApiClient.getDota2Game(gameId);
    }

    // Heroes
    @Override
    public JsonNode getHeroes() {
        return pandaScoreApiClient.getDota2Heroes();
    }

    @Override
    public JsonNode getHero(String heroId) {
        return pandaScoreApiClient.getDota2Hero(heroId);
    }

    // Items
    @Override
    public JsonNode getItems() {
        return pandaScoreApiClient.getDota2Items();
    }

    @Override
    public JsonNode getItem(String itemId) {
        return pandaScoreApiClient.getDota2Item(itemId);
    }

    // Leagues
    @Override
    public JsonNode getLeagues() {
        return pandaScoreApiClient.getDota2Leagues();
    }

    // Matches
    @Override
    public JsonNode getMatches() {
        return pandaScoreApiClient.getDota2Matches();
    }

    @Override
    public JsonNode getMatchesPast() {
        return pandaScoreApiClient.getDota2MatchesPast();
    }

    @Override
    public JsonNode getMatchesRunning() {
        return pandaScoreApiClient.getDota2MatchesRunning();
    }

    @Override
    public JsonNode getMatchesUpcoming() {
        return pandaScoreApiClient.getDota2MatchesUpcoming();
    }

    @Override
    public JsonNode getMatch(String matchId) {
        return pandaScoreApiClient.getDota2Match(matchId);
    }

    // Players
    @Override
    public JsonNode getPlayers() {
        return pandaScoreApiClient.getDota2Players();
    }

    @Override
    public JsonNode getPlayer(String playerId) {
        return pandaScoreApiClient.getDota2Player(playerId);
    }

    // Series
    @Override
    public JsonNode getSeries() {
        return pandaScoreApiClient.getDota2Series();
    }

    @Override
    public JsonNode getSeriesPast() {
        return pandaScoreApiClient.getDota2SeriesPast();
    }

    @Override
    public JsonNode getSeriesRunning() {
        return pandaScoreApiClient.getDota2SeriesRunning();
    }

    @Override
    public JsonNode getSeriesUpcoming() {
        return pandaScoreApiClient.getDota2SeriesUpcoming();
    }

    @Override
    public JsonNode getSeriesTeams(String seriesId) {
        return pandaScoreApiClient.getDota2SeriesTeams(seriesId);
    }

    // Teams
    @Override
    public JsonNode getTeams() {
        return pandaScoreApiClient.getDota2Teams();
    }

    @Override
    public JsonNode getTeam(String teamId) {
        return pandaScoreApiClient.getDota2Team(teamId);
    }

    // Tournaments
    @Override
    public JsonNode getTournaments() {
        return pandaScoreApiClient.getDota2Tournaments();
    }

    @Override
    public JsonNode getTournamentsPast() {
        return pandaScoreApiClient.getDota2TournamentsPast();
    }

    @Override
    public JsonNode getTournamentsRunning() {
        return pandaScoreApiClient.getDota2TournamentsRunning();
    }

    @Override
    public JsonNode getTournamentsUpcoming() {
        return pandaScoreApiClient.getDota2TournamentsUpcoming();
    }

    @Override
    public JsonNode getTournament(String tournamentId) {
        return pandaScoreApiClient.getDota2Tournament(tournamentId);
    }
}
