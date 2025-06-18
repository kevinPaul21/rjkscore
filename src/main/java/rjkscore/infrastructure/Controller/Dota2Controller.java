package rjkscore.infrastructure.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import rjkscore.application.service.Dota2Service;

@RestController
@RequestMapping("/api/pandascore/dota2")
public class Dota2Controller {

    private final Dota2Service dota2Service;

    public Dota2Controller(Dota2Service dota2Service) {
        this.dota2Service = dota2Service;
    }

    // Abilities
    @GetMapping("/abilities")
    public JsonNode getAbilities() {
        return dota2Service.getAbilities();
    }

    @GetMapping("/abilities/{id}")
    public JsonNode getAbility(@PathVariable("id") String id) {
        return dota2Service.getAbility(id);
    }

    // Games
    @GetMapping("/games/{id}")
    public JsonNode getGame(@PathVariable("id") String id) {
        return dota2Service.getGame(id);
    }

    // Heroes
    @GetMapping("/heroes")
    public JsonNode getHeroes() {
        return dota2Service.getHeroes();
    }

    @GetMapping("/heroes/{id}")
    public JsonNode getHero(@PathVariable("id") String id) {
        return dota2Service.getHero(id);
    }

    // Items
    @GetMapping("/items")
    public JsonNode getItems() {
        return dota2Service.getItems();
    }

    @GetMapping("/items/{id}")
    public JsonNode getItem(@PathVariable("id") String id) {
        return dota2Service.getItem(id);
    }

    // Leagues
    @GetMapping("/leagues")
    public JsonNode getLeagues() {
        return dota2Service.getLeagues();
    }

    // Matches
    @GetMapping("/matches")
    public JsonNode getMatches() {
        return dota2Service.getMatches();
    }

    @GetMapping("/matches/past")
    public JsonNode getMatchesPast() {
        return dota2Service.getMatchesPast();
    }

    @GetMapping("/matches/running")
    public JsonNode getMatchesRunning() {
        return dota2Service.getMatchesRunning();
    }

    @GetMapping("/matches/upcoming")
    public JsonNode getMatchesUpcoming() {
        return dota2Service.getMatchesUpcoming();
    }

    @GetMapping("/matches/{id}")
    public JsonNode getMatch(@PathVariable("id") String id) {
        return dota2Service.getMatch(id);
    }

    // Players
    @GetMapping("/players")
    public JsonNode getPlayers() {
        return dota2Service.getPlayers();
    }

    @GetMapping("/players/{id}")
    public JsonNode getPlayer(@PathVariable("id") String id) {
        return dota2Service.getPlayer(id);
    }

    // Series
    @GetMapping("/series")
    public JsonNode getSeries() {
        return dota2Service.getSeries();
    }

    @GetMapping("/series/past")
    public JsonNode getSeriesPast() {
        return dota2Service.getSeriesPast();
    }

    @GetMapping("/series/running")
    public JsonNode getSeriesRunning() {
        return dota2Service.getSeriesRunning();
    }

    @GetMapping("/series/upcoming")
    public JsonNode getSeriesUpcoming() {
        return dota2Service.getSeriesUpcoming();
    }

    @GetMapping("/series/{id}/teams")
    public JsonNode getSeriesTeams(@PathVariable("id") String id) {
        return dota2Service.getSeriesTeams(id);
    }

    // Teams
    @GetMapping("/teams")
    public JsonNode getTeams() {
        return dota2Service.getTeams();
    }

    @GetMapping("/teams/{id}")
    public JsonNode getTeam(@PathVariable("id") String id) {
        return dota2Service.getTeam(id);
    }

    // Tournaments
    @GetMapping("/tournaments")
    public JsonNode getTournaments() {
        return dota2Service.getTournaments();
    }

    @GetMapping("/tournaments/past")
    public JsonNode getTournamentsPast() {
        return dota2Service.getTournamentsPast();
    }

    @GetMapping("/tournaments/running")
    public JsonNode getTournamentsRunning() {
        return dota2Service.getTournamentsRunning();
    }

    @GetMapping("/tournaments/upcoming")
    public JsonNode getTournamentsUpcoming() {
        return dota2Service.getTournamentsUpcoming();
    }

    @GetMapping("/tournaments/{id}")
    public JsonNode getTournament(@PathVariable("id") String id) {
        return dota2Service.getTournament(id);
    }
}
