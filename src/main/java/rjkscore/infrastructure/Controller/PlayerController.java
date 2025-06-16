package rjkscore.infrastructure.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import rjkscore.application.service.PlayerService;

@RestController
@RequestMapping("/api/pandascore")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public JsonNode getPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping("/players/{player}")
    public JsonNode getPlayer(@PathVariable("player") String player) {
        return playerService.getPlayer(player);
    }

    @GetMapping("/players/{player}/leagues")
    public JsonNode getPlayerLeagues(@PathVariable("player") String player) {
        return playerService.getPlayerLeagues(player);
    }

    @GetMapping("/players/{player}/matches")
    public JsonNode getPlayerMatches(@PathVariable("player") String player) {
        return playerService.getPlayerMatches(player);
    }

    @GetMapping("/players/{player}/series")
    public JsonNode getPlayerSeries(@PathVariable("player") String player) {
        return playerService.getPlayerSeries(player);
    }

    @GetMapping("/players/{player}/tournaments")
    public JsonNode getPlayerTournaments(@PathVariable("player") String player) {
        return playerService.getPlayerTournaments(player);
    }
}
