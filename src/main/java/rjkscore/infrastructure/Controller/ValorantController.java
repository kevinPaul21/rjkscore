package rjkscore.infrastructure.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import rjkscore.application.service.ValorantService;

@RestController
@RequestMapping("/api/pandascore/valorant")
public class ValorantController {

    private final ValorantService valorantService;

    public ValorantController(ValorantService valorantService) {
        this.valorantService = valorantService;
    }

    // Abilities
    @GetMapping("/abilities")
    public JsonNode getAbilities() {
        return valorantService.getAbilities();
    }

    @GetMapping("/abilities/{id}")
    public JsonNode getAbility(@PathVariable("id") String id) {
        return valorantService.getAbility(id);
    }

    // Agents
    @GetMapping("/agents")
    public JsonNode getAgents() {
        return valorantService.getAgents();
    }

    @GetMapping("/agents/{id}")
    public JsonNode getAgent(@PathVariable("id") String id) {
        return valorantService.getAgent(id);
    }

    // Leagues
    @GetMapping("/leagues")
    public JsonNode getLeagues() {
        return valorantService.getLeagues();
    }

    // Maps
    @GetMapping("/maps")
    public JsonNode getMaps() {
        return valorantService.getMaps();
    }

    @GetMapping("/maps/{id}")
    public JsonNode getMap(@PathVariable("id") String id) {
        return valorantService.getMap(id);
    }

    // Matches
    @GetMapping("/matches")
    public JsonNode getMatches() {
        return valorantService.getMatches();
    }

    @GetMapping("/matches/past")
    public JsonNode getMatchesPast() {
        return valorantService.getMatchesPast();
    }

    @GetMapping("/matches/running")
    public JsonNode getMatchesRunning() {
        return valorantService.getMatchesRunning();
    }

    @GetMapping("/matches/upcoming")
    public JsonNode getMatchesUpcoming() {
        return valorantService.getMatchesUpcoming();
    }

    // Players
    @GetMapping("/players")
    public JsonNode getPlayers() {
        return valorantService.getPlayers();
    }

    // Series
    @GetMapping("/series")
    public JsonNode getSeries() {
        return valorantService.getSeries();
    }

    @GetMapping("/series/past")
    public JsonNode getSeriesPast() {
        return valorantService.getSeriesPast();
    }

    @GetMapping("/series/running")
    public JsonNode getSeriesRunning() {
        return valorantService.getSeriesRunning();
    }

    @GetMapping("/series/upcoming")
    public JsonNode getSeriesUpcoming() {
        return valorantService.getSeriesUpcoming();
    }

    // Teams
    @GetMapping("/teams")
    public JsonNode getTeams() {
        return valorantService.getTeams();
    }

    // Tournaments
    @GetMapping("/tournaments")
    public JsonNode getTournaments() {
        return valorantService.getTournaments();
    }

    @GetMapping("/tournaments/past")
    public JsonNode getTournamentsPast() {
        return valorantService.getTournamentsPast();
    }

    @GetMapping("/tournaments/running")
    public JsonNode getTournamentsRunning() {
        return valorantService.getTournamentsRunning();
    }

    @GetMapping("/tournaments/upcoming")
    public JsonNode getTournamentsUpcoming() {
        return valorantService.getTournamentsUpcoming();
    }

    // Weapons
    @GetMapping("/weapons")
    public JsonNode getWeapons() {
        return valorantService.getWeapons();
    }

    @GetMapping("/weapons/{id}")
    public JsonNode getWeapon(@PathVariable("id") String id) {
        return valorantService.getWeapon(id);
    }
}
