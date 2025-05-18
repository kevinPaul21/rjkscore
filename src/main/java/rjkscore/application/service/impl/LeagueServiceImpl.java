package rjkscore.application.service.impl;

import org.springframework.stereotype.Service;
import rjkscore.application.service.LeagueService;
import rjkscore.infrastructure.Client.SportDevsApiClient;
import rjkscore.infrastructure.Dto.Response.LeagueDto;

import java.util.List;

@Service
public class LeagueServiceImpl implements LeagueService {

    private final SportDevsApiClient sportDevsApiClient;

    public LeagueServiceImpl(SportDevsApiClient sportDevsApiClient) {
        this.sportDevsApiClient = sportDevsApiClient;
    }

    @Override
    public List<LeagueDto> getAllLeagues() {
        List<LeagueDto> result = sportDevsApiClient.getLeagues();
        System.out.println("LISTA EN SERVICIO: " + result.size());
        return result;
    }
}