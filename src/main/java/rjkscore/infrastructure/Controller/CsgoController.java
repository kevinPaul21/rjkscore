package rjkscore.infrastructure.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import rjkscore.application.service.CsgoService;

@RestController
@RequestMapping("/api/pandascore/csgo")
public class CsgoController {

    private final CsgoService csgoService;

    public CsgoController(CsgoService csgoService) {
        this.csgoService = csgoService;
    }

    // Games
    @GetMapping("/games")
    public JsonNode getGames() {
        return csgoService.getGames();
    }

    @GetMapping("/games/{id}")
    public JsonNode getGame(@PathVariable("id") String id) {
        return csgoService.getGame(id);
    }

    @GetMapping("/games/{id}/events")
    public JsonNode getGameEvents(@PathVariable("id") String id) {
        return csgoService.getGameEvents(id);
    }

    @GetMapping("/games/{id}/rounds")
    public JsonNode getGameRounds(@PathVariable("id") String id) {
        return csgoService.getGameRounds(id);
    }

    // Leagues
    @GetMapping("/leagues")
    public JsonNode getLeagues() {
        return csgoService.getLeagues();
    }

    // Maps
    @GetMapping("/maps")
    public JsonNode getMaps() {
        return csgoService.getMaps();
    }

    @GetMapping("/maps/{id}")
    public JsonNode getMap(@PathVariable("id") String id) {
        return csgoService.getMap(id);
    }

    // Matches
    @GetMapping("/matches")
    public JsonNode getMatches() {
        return csgoService.getMatches();
    }

    @GetMapping("/matches/past")
    public JsonNode getMatchesPast() {
        return csgoService.getMatchesPast();
    }

    @GetMapping("/matches/running")
    public JsonNode getMatchesRunning() {
        return csgoService.getMatchesRunning();
    }

    @GetMapping("/matches/upcoming")
    public JsonNode getMatchesUpcoming() {
        return csgoService.getMatchesUpcoming();
    }

    @GetMapping("/matches/{id}")
    public JsonNode getMatch(@PathVariable("id") String id) {
        return csgoService.getMatch(id);
    }

    // Stats
    @GetMapping("/stats/players")
    public JsonNode getPlayerStats() {
        return csgoService.getPlayerStats();
    }

    @GetMapping("/stats/teams")
    public JsonNode getTeamStats() {
        return csgoService.getTeamStats();
    }

    @GetMapping("/stats/tournaments")
    public JsonNode getTournamentStats() {
        return csgoService.getTournamentStats();
    }

    // Players
    @GetMapping("/players")
    public JsonNode getPlayers() {
        return csgoService.getPlayers();
    }

    @GetMapping("/players/{id}")
    public JsonNode getPlayer(@PathVariable("id") String id) {
        return csgoService.getPlayer(id);
    }

    // Teams
    @GetMapping("/teams")
    public JsonNode getTeams() {
        return csgoService.getTeams();
    }

    @GetMapping("/teams/{id}")
    public JsonNode getTeam(@PathVariable("id") String id) {
        return csgoService.getTeam(id);
    }

    //Series
    @GetMapping("/series")
    public JsonNode getSeries() {
        return csgoService.getSeries();
    }

    // Tournaments
    @GetMapping("/tournaments")
    public JsonNode getTournaments() {
        return csgoService.getTournaments();
    }

    @GetMapping("/tournaments/past")
    public JsonNode getTournamentsPast() {
        return csgoService.getTournamentsPast();
    }

    @GetMapping("/tournaments/running")
    public JsonNode getTournamentsRunning() {
        return csgoService.getTournamentsRunning();
    }

    @GetMapping("/tournaments/upcoming")
    public JsonNode getTournamentsUpcoming() {
        return csgoService.getTournamentsUpcoming();
    }

    @GetMapping("/tournaments/{id}")
    public JsonNode getTournament(@PathVariable("id") String id) {
        return csgoService.getTournament(id);
    }

    // Weapons
    @GetMapping("/weapons")
    public JsonNode getWeapons() {
        return csgoService.getWeapons();
    }

    @GetMapping("/weapons/{id}")
    public JsonNode getWeapon(@PathVariable("id") String id) {
        return csgoService.getWeapon(id);
    }
}
