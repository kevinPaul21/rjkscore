package rjkscore.infrastructure.Client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PandaScoreApiClient {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${pandascore.api.token}")
    private String apiToken;

    public PandaScoreApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.objectMapper = new ObjectMapper();
    }

    private JsonNode fetchList(String url) {
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
            return objectMapper.readTree(json);
        } catch (Exception e) {
            e.printStackTrace();
            return objectMapper.createArrayNode();
        }
    }

    public JsonNode getTeams() {
        return fetchList("https://api.pandascore.co/teams");
    }

    public JsonNode getPlayers() {
        return fetchList("https://api.pandascore.co/players");
    }

    public JsonNode getMatches() {
        return fetchList("https://api.pandascore.co/matches");
    }
}
