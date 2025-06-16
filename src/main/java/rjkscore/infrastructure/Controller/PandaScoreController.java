package rjkscore.infrastructure.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import rjkscore.application.service.PandaScoreService;

@RestController
@RequestMapping("/api")
public class PandaScoreController {

    private final PandaScoreService pandaScoreService;

    public PandaScoreController(PandaScoreService pandaScoreService) {
        this.pandaScoreService = pandaScoreService;
    }

    @GetMapping("/teams")
    public JsonNode getTeams() {
        return pandaScoreService.getTeams();
    }

    @GetMapping("/players")
    public JsonNode getPlayers() {
        return pandaScoreService.getPlayers();
    }

    @GetMapping("/matches")
    public JsonNode getMatches() {
        return pandaScoreService.getMatches();
    }

    @GetMapping("/pandascore/leagues")
    public JsonNode getLeagues() {
        return pandaScoreService.getLeagues();
    }

    @GetMapping("/pandascore/leagues/{league}")
    public JsonNode getLeague(@PathVariable String league) {
        return pandaScoreService.getLeague(league);
    }

    @GetMapping("/pandascore/leagues/{league}/tournaments")
    public JsonNode getLeagueTournaments(@PathVariable String league) {
        return pandaScoreService.getLeagueTournaments(league);
    }

    @GetMapping("/pandascore/leagues/{league}/series")
    public JsonNode getLeagueSeries(@PathVariable String league) {
        return pandaScoreService.getLeagueSeries(league);
    }

    @GetMapping("/pandascore/leagues/{league}/matches/upcoming")
    public JsonNode getLeagueMatchesUpcoming(@PathVariable String league) {
        return pandaScoreService.getLeagueMatchesUpcoming(league);
    }

    @GetMapping("/pandascore/leagues/{league}/matches/running")
    public JsonNode getLeagueMatchesRunning(@PathVariable String league) {
        return pandaScoreService.getLeagueMatchesRunning(league);
    }

    @GetMapping("/pandascore/leagues/{league}/matches/past")
    public JsonNode getLeagueMatchesPast(@PathVariable String league) {
        return pandaScoreService.getLeagueMatchesPast(league);
    }

    @GetMapping("/pandascore/leagues/{league}/matches")
    public JsonNode getLeagueMatches(@PathVariable String league) {
        return pandaScoreService.getLeagueMatches(league);
    }
}
