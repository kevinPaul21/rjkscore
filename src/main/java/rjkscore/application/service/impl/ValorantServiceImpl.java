package rjkscore.application.service.impl;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

import rjkscore.application.service.ValorantService;
import rjkscore.infrastructure.Client.PandaScoreApiClient;

@Service
public class ValorantServiceImpl implements ValorantService {

    private final PandaScoreApiClient pandaScoreApiClient;

    public ValorantServiceImpl(PandaScoreApiClient pandaScoreApiClient) {
        this.pandaScoreApiClient = pandaScoreApiClient;
    }

    // Abilities
    @Override
    public JsonNode getAbilities() {
        return pandaScoreApiClient.getValorantAbilities();
    }

    @Override
    public JsonNode getAbility(String abilityId) {
        return pandaScoreApiClient.getValorantAbility(abilityId);
    }

    // Agents
    @Override
    public JsonNode getAgents() {
        return pandaScoreApiClient.getValorantAgents();
    }

    @Override
    public JsonNode getAgent(String agentId) {
        return pandaScoreApiClient.getValorantAgent(agentId);
    }

    // Leagues
    @Override
    public JsonNode getLeagues() {
        return pandaScoreApiClient.getValorantLeagues();
    }

    // Maps
    @Override
    public JsonNode getMaps() {
        return pandaScoreApiClient.getValorantMaps();
    }

    @Override
    public JsonNode getMap(String mapId) {
        return pandaScoreApiClient.getValorantMap(mapId);
    }

    // Matches
    @Override
    public JsonNode getMatches() {
        return pandaScoreApiClient.getValorantMatches();
    }

    @Override
    public JsonNode getMatchesPast() {
        return pandaScoreApiClient.getValorantMatchesPast();
    }

    @Override
    public JsonNode getMatchesRunning() {
        return pandaScoreApiClient.getValorantMatchesRunning();
    }

    @Override
    public JsonNode getMatchesUpcoming() {
        return pandaScoreApiClient.getValorantMatchesUpcoming();
    }

    // Players
    @Override
    public JsonNode getPlayers() {
        return pandaScoreApiClient.getValorantPlayers();
    }

    // Series
    @Override
    public JsonNode getSeries() {
        return pandaScoreApiClient.getValorantSeries();
    }

    @Override
    public JsonNode getSeriesPast() {
        return pandaScoreApiClient.getValorantSeriesPast();
    }

    @Override
    public JsonNode getSeriesRunning() {
        return pandaScoreApiClient.getValorantSeriesRunning();
    }

    @Override
    public JsonNode getSeriesUpcoming() {
        return pandaScoreApiClient.getValorantSeriesUpcoming();
    }

    // Teams
    @Override
    public JsonNode getTeams() {
        return pandaScoreApiClient.getValorantTeams();
    }

    // Tournaments
    @Override
    public JsonNode getTournaments() {
        return pandaScoreApiClient.getValorantTournaments();
    }

    @Override
    public JsonNode getTournamentsPast() {
        return pandaScoreApiClient.getValorantTournamentsPast();
    }

    @Override
    public JsonNode getTournamentsRunning() {
        return pandaScoreApiClient.getValorantTournamentsRunning();
    }

    @Override
    public JsonNode getTournamentsUpcoming() {
        return pandaScoreApiClient.getValorantTournamentsUpcoming();
    }

    // Weapons
    @Override
    public JsonNode getWeapons() {
        return pandaScoreApiClient.getValorantWeapons();
    }

    @Override
    public JsonNode getWeapon(String weaponId) {
        return pandaScoreApiClient.getValorantWeapon(weaponId);
    }
}
