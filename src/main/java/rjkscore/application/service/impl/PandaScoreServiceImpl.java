package rjkscore.application.service.impl;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

import rjkscore.application.service.PandaScoreService;
import rjkscore.infrastructure.Client.PandaScoreApiClient;

@Service
public class PandaScoreServiceImpl implements PandaScoreService {

    private final PandaScoreApiClient pandaScoreApiClient;

    public PandaScoreServiceImpl(PandaScoreApiClient pandaScoreApiClient) {
        this.pandaScoreApiClient = pandaScoreApiClient;
    }

    @Override
    public JsonNode getTeams() {
        return pandaScoreApiClient.getTeams();
    }

    @Override
    public JsonNode getPlayers() {
        return pandaScoreApiClient.getPlayers();
    }

    @Override
    public JsonNode getMatches() {
        return pandaScoreApiClient.getMatches();
    }

    @Override
    public JsonNode getMatchesPast() {
        return pandaScoreApiClient.getMatchesPast();
    }

    @Override
    public JsonNode getMatchesRunning() {
        return pandaScoreApiClient.getMatchesRunning();
    }

    @Override
    public JsonNode getMatchesUpcoming() {
        return pandaScoreApiClient.getMatchesUpcoming();
    }

    @Override
    public JsonNode getMatch(String matchIdOrSlug) {
        return pandaScoreApiClient.getMatch(matchIdOrSlug);
    }

    @Override
    public JsonNode getMatchOpponents(String matchIdOrSlug) {
        return pandaScoreApiClient.getMatchOpponents(matchIdOrSlug);
    }

    @Override
    public JsonNode getLeagues() {
        return pandaScoreApiClient.getLeagues();
    }

    @Override
    public JsonNode getLeague(String league) {
        return pandaScoreApiClient.getLeague(league);
    }

    @Override
    public JsonNode getLeagueTournaments(String league) {
        return pandaScoreApiClient.getLeagueTournaments(league);
    }

    @Override
    public JsonNode getLeagueSeries(String league) {
        return pandaScoreApiClient.getLeagueSeries(league);
    }

    @Override
    public JsonNode getLeagueMatchesUpcoming(String league) {
        return pandaScoreApiClient.getLeagueMatchesUpcoming(league);
    }

    @Override
    public JsonNode getLeagueMatchesRunning(String league) {
        return pandaScoreApiClient.getLeagueMatchesRunning(league);
    }

    @Override
    public JsonNode getLeagueMatchesPast(String league) {
        return pandaScoreApiClient.getLeagueMatchesPast(league);
    }

    @Override
    public JsonNode getLeagueMatches(String league) {
        return pandaScoreApiClient.getLeagueMatches(league);
    }

    @Override
    public JsonNode getVideogames() {
        return pandaScoreApiClient.getVideogames();
    }

    @Override
    public JsonNode getVideogame(String videogameIdOrSlug) {
        return pandaScoreApiClient.getVideogame(videogameIdOrSlug);
    }

    @Override
    public JsonNode getVideogameLeagues(String videogameIdOrSlug) {
        return pandaScoreApiClient.getVideogameLeagues(videogameIdOrSlug);
    }

    @Override
    public JsonNode getVideogameSeries(String videogameIdOrSlug) {
        return pandaScoreApiClient.getVideogameSeries(videogameIdOrSlug);
    }

    @Override
    public JsonNode getVideogameTitles(String videogameIdOrSlug) {
        return pandaScoreApiClient.getVideogameTitles(videogameIdOrSlug);
    }

    @Override
    public JsonNode getVideogameTournaments(String videogameIdOrSlug) {
        return pandaScoreApiClient.getVideogameTournaments(videogameIdOrSlug);
    }

    @Override
    public JsonNode getVideogameVersions(String videogameIdOrSlug) {
        return pandaScoreApiClient.getVideogameVersions(videogameIdOrSlug);
    }
}
