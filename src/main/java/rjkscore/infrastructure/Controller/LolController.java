package rjkscore.infrastructure.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import rjkscore.application.service.LolService;

@RestController
@RequestMapping("/api/pandascore/lol")
public class LolController {

    private final LolService lolService;

    public LolController(LolService lolService) {
        this.lolService = lolService;
    }

    // Champions
    @GetMapping("/champions")
    public JsonNode getChampions() {
        return lolService.getChampions();
    }

    @GetMapping("/champions/{id}")
    public JsonNode getChampion(@PathVariable("id") String id) {
        return lolService.getChampion(id);
    }

    // Items
    @GetMapping("/items")
    public JsonNode getItems() {
        return lolService.getItems();
    }

    @GetMapping("/items/{id}")
    public JsonNode getItem(@PathVariable("id") String id) {
        return lolService.getItem(id);
    }

    // Leagues
    @GetMapping("/leagues")
    public JsonNode getLeagues() {
        return lolService.getLeagues();
    }

    // Masteries
    @GetMapping("/masteries")
    public JsonNode getMasteries() {
        return lolService.getMasteries();
    }

    @GetMapping("/masteries/{id}")
    public JsonNode getMastery(@PathVariable("id") String id) {
        return lolService.getMastery(id);
    }

    // Matches
    @GetMapping("/matches")
    public JsonNode getMatches() {
        return lolService.getMatches();
    }

    @GetMapping("/matches/past")
    public JsonNode getMatchesPast() {
        return lolService.getMatchesPast();
    }

    @GetMapping("/matches/running")
    public JsonNode getMatchesRunning() {
        return lolService.getMatchesRunning();
    }

    @GetMapping("/matches/upcoming")
    public JsonNode getMatchesUpcoming() {
        return lolService.getMatchesUpcoming();
    }

    @GetMapping("/matches/{id}")
    public JsonNode getMatch(@PathVariable("id") String id) {
        return lolService.getMatch(id);
    }

    // Players
    @GetMapping("/players")
    public JsonNode getPlayers() {
        return lolService.getPlayers();
    }

    @GetMapping("/players/{id}")
    public JsonNode getPlayer(@PathVariable("id") String id) {
        return lolService.getPlayer(id);
    }

    // Runes
    @GetMapping("/runes-reforged")
    public JsonNode getRunesReforged() {
        return lolService.getRunesReforged();
    }

    @GetMapping("/runes-reforged-paths")
    public JsonNode getRunesReforgedPaths() {
        return lolService.getRunesReforgedPaths();
    }

    @GetMapping("/runes-reforged-paths/{id}")
    public JsonNode getRunesReforgedPath(@PathVariable("id") String id) {
        return lolService.getRunesReforgedPath(id);
    }

    @GetMapping("/runes-reforged/{id}")
    public JsonNode getRuneReforged(@PathVariable("id") String id) {
        return lolService.getRuneReforged(id);
    }

    // Series
    @GetMapping("/series")
    public JsonNode getSeries() {
        return lolService.getSeries();
    }

    @GetMapping("/series/past")
    public JsonNode getSeriesPast() {
        return lolService.getSeriesPast();
    }

    @GetMapping("/series/running")
    public JsonNode getSeriesRunning() {
        return lolService.getSeriesRunning();
    }

    @GetMapping("/series/upcoming")
    public JsonNode getSeriesUpcoming() {
        return lolService.getSeriesUpcoming();
    }

    @GetMapping("/series/{id}/teams")
    public JsonNode getSeriesTeams(@PathVariable("id") String id) {
        return lolService.getSeriesTeams(id);
    }

    // Teams
    @GetMapping("/teams")
    public JsonNode getTeams() {
        return lolService.getTeams();
    }

    @GetMapping("/teams/{id}")
    public JsonNode getTeam(@PathVariable("id") String id) {
        return lolService.getTeam(id);
    }

    // Spells
    @GetMapping("/spells")
    public JsonNode getSpells() {
        return lolService.getSpells();
    }

    @GetMapping("/spells/{id}")
    public JsonNode getSpell(@PathVariable("id") String id) {
        return lolService.getSpell(id);
    }

    // Tournaments
    @GetMapping("/tournaments")
    public JsonNode getTournaments() {
        return lolService.getTournaments();
    }

    @GetMapping("/tournaments/{id}")
    public JsonNode getTournament(@PathVariable("id") String id) {
        return lolService.getTournament(id);
    }

    @GetMapping("/tournaments/past")
    public JsonNode getTournamentsPast() {
        return lolService.getTournamentsPast();
    }

    @GetMapping("/tournaments/running")
    public JsonNode getTournamentsRunning() {
        return lolService.getTournamentsRunning();
    }

    @GetMapping("/tournaments/upcoming")
    public JsonNode getTournamentsUpcoming() {
        return lolService.getTournamentsUpcoming();
    }
}
