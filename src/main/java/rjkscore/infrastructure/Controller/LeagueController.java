package rjkscore.infrastructure.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rjkscore.application.service.LeagueService;
import rjkscore.infrastructure.Dto.Response.LeagueDto;

import java.util.List;

@RestController
@RequestMapping("/api/leagues")
public class LeagueController {

    private final LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

     @GetMapping
    public List<LeagueDto> getLeagues() {
        List<LeagueDto> lista = leagueService.getAllLeagues();
        System.out.println("LISTA ENVIADA AL CLIENTE: " + lista.size());
        return lista;
    }

}