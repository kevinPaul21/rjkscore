package rjkscore.infrastructure.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import rjkscore.application.service.PandaScoreService;

@RestController
@RequestMapping("/api/pandascore")
public class VideogameController {

    private final PandaScoreService pandaScoreService;

    public VideogameController(PandaScoreService pandaScoreService) {
        this.pandaScoreService = pandaScoreService;
    }

    @GetMapping("/videogames")
    public JsonNode getVideogames() {
        return pandaScoreService.getVideogames();
    }

    @GetMapping("/videogames/{videogame}")
    public JsonNode getVideogame(@PathVariable("videogame") String videogame) {
        return pandaScoreService.getVideogame(videogame);
    }

    @GetMapping("/videogames/{videogame}/leagues")
    public JsonNode getVideogameLeagues(@PathVariable("videogame") String videogame) {
        return pandaScoreService.getVideogameLeagues(videogame);
    }

    @GetMapping("/videogames/{videogame}/series")
    public JsonNode getVideogameSeries(@PathVariable("videogame") String videogame) {
        return pandaScoreService.getVideogameSeries(videogame);
    }

    @GetMapping("/videogames/{videogame}/titles")
    public JsonNode getVideogameTitles(@PathVariable("videogame") String videogame) {
        return pandaScoreService.getVideogameTitles(videogame);
    }

    @GetMapping("/videogames/{videogame}/tournaments")
    public JsonNode getVideogameTournaments(@PathVariable("videogame") String videogame) {
        return pandaScoreService.getVideogameTournaments(videogame);
    }

    @GetMapping("/videogames/{videogame}/versions")
    public JsonNode getVideogameVersions(@PathVariable("videogame") String videogame) {
        return pandaScoreService.getVideogameVersions(videogame);
    }
}
