package rjkscore.infrastructure.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import rjkscore.application.service.PandaScoreService;

@RestController
@RequestMapping("/api/pandascore")
public class MatchController {

    private final PandaScoreService pandaScoreService;

    public MatchController(PandaScoreService pandaScoreService) {
        this.pandaScoreService = pandaScoreService;
    }

    @GetMapping("/matches")
    public JsonNode getMatches() {
        return pandaScoreService.getMatches();
    }

    @GetMapping("/matches/past")
    public JsonNode getMatchesPast() {
        return pandaScoreService.getMatchesPast();
    }

    @GetMapping("/matches/running")
    public JsonNode getMatchesRunning() {
        return pandaScoreService.getMatchesRunning();
    }

    @GetMapping("/matches/upcoming")
    public JsonNode getMatchesUpcoming() {
        return pandaScoreService.getMatchesUpcoming();
    }

    @GetMapping("/matches/{match}")
    public JsonNode getMatch(@PathVariable("match") String match) {
        return pandaScoreService.getMatch(match);
    }

    @GetMapping("/matches/{match}/opponents")
    public JsonNode getMatchOpponents(@PathVariable("match") String match) {
        return pandaScoreService.getMatchOpponents(match);
    }
}
