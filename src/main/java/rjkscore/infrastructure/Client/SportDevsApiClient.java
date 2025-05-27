package rjkscore.infrastructure.Client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import rjkscore.infrastructure.Dto.Response.LeagueDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.List;
@Component
public class SportDevsApiClient {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${sportdevs.api.token}")
    private String apiToken;

    public SportDevsApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.objectMapper = new ObjectMapper();
    }

  public List<LeagueDto> getLeagues() {
    String url = "https://esports.sportdevs.com/leagues?lang=en&limit=50";
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer " + apiToken);
    headers.set("Accept", "application/json");

    HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

    try {
        ResponseEntity<String> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            requestEntity,
            String.class
        );
        String json = response.getBody();
        System.out.println("SPORTDEVS RAW RESPONSE: " + json);

        List<LeagueDto> leagues = objectMapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<List<LeagueDto>>() {});
        System.out.println("LEAGUES PARSED SIZE: " + leagues.size());
        return leagues;
    } catch (Exception e) {
        System.out.println("ERROR PARSEANDO SPORTDEVS:");
        e.printStackTrace();
        return Collections.emptyList();
    }
}
}