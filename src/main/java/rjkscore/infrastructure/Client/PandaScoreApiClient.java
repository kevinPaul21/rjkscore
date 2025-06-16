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
        return fetchList(
            "https://api.pandascore.co/teams"
        );
    }

    public JsonNode getTeam(String teamIdOrSlug) {
        return fetchList("https://api.pandascore.co/teams/" + teamIdOrSlug);
    }

    public JsonNode getTeamLeagues(String teamIdOrSlug) {
        return fetchList(
            "https://api.pandascore.co/teams/" + teamIdOrSlug +
            "/leagues?sort=id&page=1&per_page=50"
        );
    }

    public JsonNode getTeamMatches(String teamIdOrSlug) {
        return fetchList(
            "https://api.pandascore.co/teams/" + teamIdOrSlug +
            "/matches?filter[match_type][0]=all_games_played&filter[status][0]=canceled" +
            "&filter[videogame][0]=1&filter[winner_type][0]=Player" +
            "&range[detailed_stats][0]=true&range[detailed_stats][1]=true" +
            "&range[draw][0]=true&range[draw][1]=true" +
            "&range[forfeit][0]=true&range[forfeit][1]=true" +
            "&range[match_type][0]=all_games_played&range[match_type][1]=all_games_played" +
            "&range[status][0]=canceled&range[status][1]=canceled" +
            "&range[winner_type][0]=Player&range[winner_type][1]=Player" +
            "&sort=begin_at&page=1&per_page=50"
        );
    }

    public JsonNode getTeamTournaments(String teamIdOrSlug) {
        return fetchList(
            "https://api.pandascore.co/teams/" + teamIdOrSlug +
            "/tournaments?filter[region][0]=ASIA&filter[tier][0]=a&filter[winner_type][0]=Player" +
            "&range[detailed_stats][0]=true&range[detailed_stats][1]=true" +
            "&range[has_bracket][0]=true&range[has_bracket][1]=true" +
            "&range[region][0]=ASIA&range[region][1]=ASIA" +
            "&range[tier][0]=a&range[tier][1]=a" +
            "&range[winner_type][0]=Player&range[winner_type][1]=Player" +
            "&sort=begin_at&page=1&per_page=50"
        );
    }

    public JsonNode getPlayers() {
        return fetchList("https://api.pandascore.co/players");
    }

    public JsonNode getPlayer(String playerIdOrSlug) {
        return fetchList("https://api.pandascore.co/players/" + playerIdOrSlug);
    }

    public JsonNode getPlayerLeagues(String playerIdOrSlug) {
        return fetchList(
            "https://api.pandascore.co/players/" + playerIdOrSlug +
            "/leagues?sort=id&page=1&per_page=50"
        );
    }

    public JsonNode getPlayerMatches(String playerIdOrSlug) {
        return fetchList(
            "https://api.pandascore.co/players/" + playerIdOrSlug +
            "/matches?filter[match_type][0]=all_games_played&filter[status][0]=canceled" +
            "&filter[videogame][0]=1&filter[winner_type][0]=Player" +
            "&range[detailed_stats][0]=true&range[detailed_stats][1]=true" +
            "&range[draw][0]=true&range[draw][1]=true" +
            "&range[forfeit][0]=true&range[forfeit][1]=true" +
            "&range[match_type][0]=all_games_played&range[match_type][1]=all_games_played" +
            "&range[status][0]=canceled&range[status][1]=canceled" +
            "&range[winner_type][0]=Player&range[winner_type][1]=Player" +
            "&sort=begin_at&page=1&per_page=50"
        );
    }

    public JsonNode getPlayerSeries(String playerIdOrSlug) {
        return fetchList(
            "https://api.pandascore.co/players/" + playerIdOrSlug +
            "/series?filter[winner_type][0]=Player" +
            "&range[winner_type][0]=Player&range[winner_type][1]=Player" +
            "&sort=begin_at&page=1&per_page=50"
        );
    }

    public JsonNode getPlayerTournaments(String playerIdOrSlug) {
        return fetchList(
            "https://api.pandascore.co/players/" + playerIdOrSlug +
            "/tournaments?filter[region][0]=ASIA&filter[tier][0]=a&filter[winner_type][0]=Player" +
            "&range[detailed_stats][0]=true&range[detailed_stats][1]=true" +
            "&range[has_bracket][0]=true&range[has_bracket][1]=true" +
            "&range[region][0]=ASIA&range[region][1]=ASIA" +
            "&range[tier][0]=a&range[tier][1]=a" +
            "&range[winner_type][0]=Player&range[winner_type][1]=Player" +
            "&sort=begin_at&page=1&per_page=50"
        );
    }

    public JsonNode getMatches() {
        return fetchList("https://api.pandascore.co/matches");
    }

    public JsonNode getMatchesPast() {
        return fetchList(
            "https://api.pandascore.co/matches/past?filter[match_type][0]=all_games_played&filter[status][0]=canceled" +
            "&filter[videogame][0]=1&filter[winner_type][0]=Player" +
            "&range[detailed_stats][0]=true&range[detailed_stats][1]=true" +
            "&range[draw][0]=true&range[draw][1]=true" +
            "&range[forfeit][0]=true&range[forfeit][1]=true" +
            "&range[match_type][0]=all_games_played&range[match_type][1]=all_games_played" +
            "&range[status][0]=canceled&range[status][1]=canceled" +
            "&range[winner_type][0]=Player&range[winner_type][1]=Player" +
            "&sort=begin_at&page=1&per_page=50"
        );
    }

    public JsonNode getMatchesRunning() {
        return fetchList(
            "https://api.pandascore.co/matches/running?filter[match_type][0]=all_games_played&filter[status][0]=canceled" +
            "&filter[videogame][0]=1&filter[winner_type][0]=Player" +
            "&range[detailed_stats][0]=true&range[detailed_stats][1]=true" +
            "&range[draw][0]=true&range[draw][1]=true" +
            "&range[forfeit][0]=true&range[forfeit][1]=true" +
            "&range[match_type][0]=all_games_played&range[match_type][1]=all_games_played" +
            "&range[status][0]=canceled&range[status][1]=canceled" +
            "&range[winner_type][0]=Player&range[winner_type][1]=Player" +
            "&sort=begin_at&page=1&per_page=50"
        );
    }

    public JsonNode getMatchesUpcoming() {
        return fetchList(
            "https://api.pandascore.co/matches/upcoming?filter[match_type][0]=all_games_played&filter[status][0]=canceled" +
            "&filter[videogame][0]=1&filter[winner_type][0]=Player" +
            "&range[detailed_stats][0]=true&range[detailed_stats][1]=true" +
            "&range[draw][0]=true&range[draw][1]=true" +
            "&range[forfeit][0]=true&range[forfeit][1]=true" +
            "&range[match_type][0]=all_games_played&range[match_type][1]=all_games_played" +
            "&range[status][0]=canceled&range[status][1]=canceled" +
            "&range[winner_type][0]=Player&range[winner_type][1]=Player" +
            "&sort=begin_at&page=1&per_page=50"
        );
    }

    public JsonNode getMatch(String matchIdOrSlug) {
        return fetchList("https://api.pandascore.co/matches/" + matchIdOrSlug);
    }

    public JsonNode getMatchOpponents(String matchIdOrSlug) {
        return fetchList("https://api.pandascore.co/matches/" + matchIdOrSlug + "/opponents");
    }

    public JsonNode getLeagues() {
        return fetchList("https://api.pandascore.co/leagues?sort=id&page=1&per_page=50");
    }

    public JsonNode getLeague(String league) {
        return fetchList("https://api.pandascore.co/leagues/" + league);
    }

    public JsonNode getLeagueTournaments(String league) {
        return fetchList(
            "https://api.pandascore.co/leagues/" + league +
            "/tournaments?filter[region][0]=ASIA&filter[tier][0]=a&filter[winner_type][0]=Player" +
            "&range[detailed_stats][0]=true&range[detailed_stats][1]=true" +
            "&range[has_bracket][0]=true&range[has_bracket][1]=true" +
            "&range[region][0]=ASIA&range[region][1]=ASIA" +
            "&range[tier][0]=a&range[tier][1]=a" +
            "&range[winner_type][0]=Player&range[winner_type][1]=Player" +
            "&sort=begin_at&page=1&per_page=50"
        );
    }

    public JsonNode getLeagueSeries(String league) {
        return fetchList(
            "https://api.pandascore.co/leagues/" + league +
            "/series?filter[winner_type][0]=Player" +
            "&range[winner_type][0]=Player&range[winner_type][1]=Player" +
            "&sort=begin_at&page=1&per_page=50"
        );
    }

    public JsonNode getLeagueMatchesUpcoming(String league) {
        return fetchList(
            "https://api.pandascore.co/leagues/" + league +
            "/matches/upcoming?filter[match_type][0]=all_games_played&filter[status][0]=canceled" +
            "&filter[videogame][0]=1&filter[winner_type][0]=Player" +
            "&range[detailed_stats][0]=true&range[detailed_stats][1]=true" +
            "&range[draw][0]=true&range[draw][1]=true" +
            "&range[forfeit][0]=true&range[forfeit][1]=true" +
            "&range[match_type][0]=all_games_played&range[match_type][1]=all_games_played" +
            "&range[status][0]=canceled&range[status][1]=canceled" +
            "&range[winner_type][0]=Player&range[winner_type][1]=Player" +
            "&sort=begin_at&page=1&per_page=50"
        );
    }

    public JsonNode getLeagueMatchesRunning(String league) {
        return fetchList(
            "https://api.pandascore.co/leagues/" + league +
            "/matches/running?filter[match_type][0]=all_games_played&filter[status][0]=canceled" +
            "&filter[videogame][0]=1&filter[winner_type][0]=Player" +
            "&range[detailed_stats][0]=true&range[detailed_stats][1]=true" +
            "&range[draw][0]=true&range[draw][1]=true" +
            "&range[forfeit][0]=true&range[forfeit][1]=true" +
            "&range[match_type][0]=all_games_played&range[match_type][1]=all_games_played" +
            "&range[status][0]=canceled&range[status][1]=canceled" +
            "&range[winner_type][0]=Player&range[winner_type][1]=Player" +
            "&sort=begin_at&page=1&per_page=50"
        );
    }

    public JsonNode getLeagueMatchesPast(String league) {
        return fetchList(
            "https://api.pandascore.co/leagues/" + league +
            "/matches/past?filter[match_type][0]=all_games_played&filter[status][0]=canceled" +
            "&filter[videogame][0]=1&filter[winner_type][0]=Player" +
            "&range[detailed_stats][0]=true&range[detailed_stats][1]=true" +
            "&range[draw][0]=true&range[draw][1]=true" +
            "&range[forfeit][0]=true&range[forfeit][1]=true" +
            "&range[match_type][0]=all_games_played&range[match_type][1]=all_games_played" +
            "&range[status][0]=canceled&range[status][1]=canceled" +
            "&range[winner_type][0]=Player&range[winner_type][1]=Player" +
            "&sort=begin_at&page=1&per_page=50"
        );
    }

    public JsonNode getLeagueMatches(String league) {
        return fetchList(
            "https://api.pandascore.co/leagues/" + league +
            "/matches?filter[match_type][0]=all_games_played&filter[status][0]=canceled" +
            "&filter[videogame][0]=1&filter[winner_type][0]=Player" +
            "&range[detailed_stats][0]=true&range[detailed_stats][1]=true" +
            "&range[draw][0]=true&range[draw][1]=true" +
            "&range[forfeit][0]=true&range[forfeit][1]=true" +
            "&range[match_type][0]=all_games_played&range[match_type][1]=all_games_played" +
            "&range[status][0]=canceled&range[status][1]=canceled" +
            "&range[winner_type][0]=Player&range[winner_type][1]=Player" +
            "&sort=begin_at&page=1&per_page=50"
        );
    }
}
