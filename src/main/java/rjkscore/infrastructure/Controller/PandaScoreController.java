package rjkscore.infrastructure.Controller;

import org.springframework.web.bind.annotation.GetMapping;
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
}
