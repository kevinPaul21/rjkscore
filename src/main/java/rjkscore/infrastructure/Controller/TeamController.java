package rjkscore.infrastructure.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import rjkscore.application.service.TeamService;

@RestController
@RequestMapping("/api/pandascore")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    public JsonNode getTeams() {
        return teamService.getTeams();
    }

    @GetMapping("/teams/{team}")
    public JsonNode getTeam(@PathVariable("team") String team) {
        return teamService.getTeam(team);
    }

    @GetMapping("/teams/{team}/leagues")
    public JsonNode getTeamLeagues(@PathVariable("team") String team) {
        return teamService.getTeamLeagues(team);
    }

    @GetMapping("/teams/{team}/matches")
    public JsonNode getTeamMatches(@PathVariable("team") String team) {
        return teamService.getTeamMatches(team);
    }

    @GetMapping("/teams/{team}/tournaments")
    public JsonNode getTeamTournaments(@PathVariable("team") String team) {
        return teamService.getTeamTournaments(team);
    }
}
