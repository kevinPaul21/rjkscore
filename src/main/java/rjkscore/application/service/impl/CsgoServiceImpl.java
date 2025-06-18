package rjkscore.application.service.impl;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

import rjkscore.application.service.CsgoService;
import rjkscore.infrastructure.Client.PandaScoreApiClient;

@Service
public class CsgoServiceImpl implements CsgoService {

    private final PandaScoreApiClient pandaScoreApiClient;

    public CsgoServiceImpl(PandaScoreApiClient pandaScoreApiClient) {
        this.pandaScoreApiClient = pandaScoreApiClient;
    }

    // Games
    @Override
    public JsonNode getGames() {
        return pandaScoreApiClient.getCsgoGames();
    }

    @Override
    public JsonNode getGame(String gameId) {
        return pandaScoreApiClient.getCsgoGame(gameId);
    }

    @Override
    public JsonNode getGameEvents(String gameId) {
        return pandaScoreApiClient.getCsgoGameEvents(gameId);
    }

    @Override
    public JsonNode getGameRounds(String gameId) {
        return pandaScoreApiClient.getCsgoGameRounds(gameId);
    }

    // Leagues
    @Override
    public JsonNode getLeagues() {
        return pandaScoreApiClient.getCsgoLeagues();
    }

    // Maps
    @Override
    public JsonNode getMaps() {
        return pandaScoreApiClient.getCsgoMaps();
    }

    @Override
    public JsonNode getMap(String mapId) {
        return pandaScoreApiClient.getCsgoMap(mapId);
    }

    // Matches
    @Override
    public JsonNode getMatches() {
        return pandaScoreApiClient.getCsgoMatches();
    }

    @Override
    public JsonNode getMatchesPast() {
        return pandaScoreApiClient.getCsgoMatchesPast();
    }

    @Override
    public JsonNode getMatchesRunning() {
        return pandaScoreApiClient.getCsgoMatchesRunning();
    }

    @Override
    public JsonNode getMatchesUpcoming() {
        return pandaScoreApiClient.getCsgoMatchesUpcoming();
    }

    @Override
    public JsonNode getMatch(String matchId) {
        return pandaScoreApiClient.getCsgoMatch(matchId);
    }

    // Stats
    @Override
    public JsonNode getPlayerStats() {
        return pandaScoreApiClient.getCsgoPlayerStats();
    }

    @Override
    public JsonNode getTeamStats() {
        return pandaScoreApiClient.getCsgoTeamStats();
    }

    @Override
    public JsonNode getTournamentStats() {
        return pandaScoreApiClient.getCsgoTournamentStats();
    }

    // Players
    @Override
    public JsonNode getPlayers() {
        return pandaScoreApiClient.getCsgoPlayers();
    }

    @Override
    public JsonNode getPlayer(String playerId) {
        return pandaScoreApiClient.getCsgoPlayer(playerId);
    }

    // Teams
    @Override
    public JsonNode getTeams() {
        return pandaScoreApiClient.getCsgoTeams();
    }

    @Override
    public JsonNode getTeam(String teamId) {
        return pandaScoreApiClient.getCsgoTeam(teamId);
    }

    // Tournaments
    @Override
    public JsonNode getTournaments() {
        return pandaScoreApiClient.getCsgoTournaments();
    }

    @Override
    public JsonNode getTournamentsPast() {
        return pandaScoreApiClient.getCsgoTournamentsPast();
    }

    @Override
    public JsonNode getTournamentsRunning() {
        return pandaScoreApiClient.getCsgoTournamentsRunning();
    }

    @Override
    public JsonNode getTournamentsUpcoming() {
        return pandaScoreApiClient.getCsgoTournamentsUpcoming();
    }

    @Override
    public JsonNode getTournament(String tournamentId) {
        return pandaScoreApiClient.getCsgoTournament(tournamentId);
    }

    // Weapons
    @Override
    public JsonNode getWeapons() {
        return pandaScoreApiClient.getCsgoWeapons();
    }

    @Override
    public JsonNode getWeapon(String weaponId) {
        return pandaScoreApiClient.getCsgoWeapon(weaponId);
    }
}
