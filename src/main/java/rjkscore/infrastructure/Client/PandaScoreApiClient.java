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
                    String.class);
            String json = response.getBody();
            return objectMapper.readTree(json);
        } catch (Exception e) {
            e.printStackTrace();
            return objectMapper.createArrayNode();
        }
    }

    public JsonNode getTeams() {
        return fetchList(
                "https://api.pandascore.co/teams");
    }

    public JsonNode getTeam(String teamIdOrSlug) {
        return fetchList("https://api.pandascore.co/teams/" + teamIdOrSlug);
    }

    public JsonNode getTeamLeagues(String teamIdOrSlug) {
        return fetchList(
                "https://api.pandascore.co/teams/" + teamIdOrSlug +
                        "/leagues");
    }

    public JsonNode getTeamMatches(String teamIdOrSlug) {
        return fetchList(
                "https://api.pandascore.co/teams/" + teamIdOrSlug +
                        "/matches");
    }

    public JsonNode getTeamTournaments(String teamIdOrSlug) {
        return fetchList(
                "https://api.pandascore.co/teams/" + teamIdOrSlug +
                        "/tournaments");
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
                        "/leagues?sort=id&page=1&per_page=50");
    }

    public JsonNode getPlayerMatches(String playerIdOrSlug) {
        return fetchList(
                "https://api.pandascore.co/players/" + playerIdOrSlug +
                        "/matches");
    }

    public JsonNode getPlayerSeries(String playerIdOrSlug) {
        return fetchList(
                "https://api.pandascore.co/players/" + playerIdOrSlug +
                        "/series?filter[winner_type][0]=Player" +
                        "&range[winner_type][0]=Player&range[winner_type][1]=Player" +
                        "&sort=begin_at&page=1&per_page=50");
    }

    public JsonNode getPlayerTournaments(String playerIdOrSlug) {
        return fetchList(
                "https://api.pandascore.co/players/" + playerIdOrSlug +
                        "/tournaments");
    }

    public JsonNode getMatches() {
        return fetchList("https://api.pandascore.co/matches");
    }

    public JsonNode getMatchesPast() {
        return fetchList(
                "https://api.pandascore.co/matches/past");
    }

    public JsonNode getMatchesRunning() {
        return fetchList(
                "https://api.pandascore.co/matches/running");
    }

    public JsonNode getMatchesUpcoming() {
        return fetchList(
                "https://api.pandascore.co/matches/upcoming");
    }

    public JsonNode getMatch(String matchIdOrSlug) {
        return fetchList("https://api.pandascore.co/matches/" + matchIdOrSlug);
    }

    public JsonNode getMatchOpponents(String matchIdOrSlug) {
        return fetchList("https://api.pandascore.co/matches/" + matchIdOrSlug + "/opponents");
    }

    public JsonNode getLeagues() {
        return fetchList("https://api.pandascore.co/leagues");
    }

    public JsonNode getLeague(String league) {
        return fetchList("https://api.pandascore.co/leagues/" + league);
    }

    public JsonNode getLeagueTournaments(String league) {
        return fetchList(
                "https://api.pandascore.co/leagues/" + league +
                        "/tournaments");
    }

    public JsonNode getLeagueSeries(String league) {
        return fetchList(
                "https://api.pandascore.co/leagues/" + league +
                        "/series");
    }

    public JsonNode getLeagueMatchesUpcoming(String league) {
        return fetchList(
                "https://api.pandascore.co/leagues/" + league +
                        "/matches/upcoming");
    }

    public JsonNode getLeagueMatchesRunning(String league) {
        return fetchList(
                "https://api.pandascore.co/leagues/" + league +
                        "/matches/running");
    }

    public JsonNode getLeagueMatchesPast(String league) {
        return fetchList(
                "https://api.pandascore.co/leagues/" + league +
                        "/matches/past");
    }

    public JsonNode getLeagueMatches(String league) {
        return fetchList(
                "https://api.pandascore.co/leagues/" + league +
                        "/matches");
    }

    public JsonNode getVideogames() {
        return fetchList("https://api.pandascore.co/videogames");
    }

    public JsonNode getVideogame(String videogameIdOrSlug) {
        return fetchList("https://api.pandascore.co/videogames/" + videogameIdOrSlug);
    }

    public JsonNode getVideogameLeagues(String videogameIdOrSlug) {
        return fetchList("https://api.pandascore.co/videogames/" + videogameIdOrSlug + "/leagues");
    }

    public JsonNode getVideogameSeries(String videogameIdOrSlug) {
        return fetchList("https://api.pandascore.co/videogames/" + videogameIdOrSlug + "/series");
    }

    public JsonNode getVideogameTitles(String videogameIdOrSlug) {
        return fetchList("https://api.pandascore.co/videogames/" + videogameIdOrSlug + "/titles");
    }

    public JsonNode getVideogameTournaments(String videogameIdOrSlug) {
        return fetchList("https://api.pandascore.co/videogames/" + videogameIdOrSlug + "/tournaments");
    }

    public JsonNode getVideogameVersions(String videogameIdOrSlug) {
        return fetchList("https://api.pandascore.co/videogames/" + videogameIdOrSlug + "/versions");
    }

    // --- CSGO endpoints ---
    public JsonNode getCsgoGames() {
        return fetchList("https://api.pandascore.co/csgo/games");
    }

    public JsonNode getCsgoGame(String id) {
        return fetchList("https://api.pandascore.co/csgo/games/" + id);
    }

    public JsonNode getCsgoGameEvents(String id) {
        return fetchList("https://api.pandascore.co/csgo/games/" + id + "/events");
    }

    public JsonNode getCsgoGameRounds(String id) {
        return fetchList("https://api.pandascore.co/csgo/games/" + id + "/rounds");
    }

    public JsonNode getCsgoLeagues() {
        return fetchList("https://api.pandascore.co/csgo/leagues");
    }

    public JsonNode getCsgoMaps() {
        return fetchList("https://api.pandascore.co/csgo/maps");
    }

    public JsonNode getCsgoMap(String id) {
        return fetchList("https://api.pandascore.co/csgo/maps/" + id);
    }

    public JsonNode getCsgoMatches() {
        return fetchList("https://api.pandascore.co/csgo/matches");
    }

    public JsonNode getCsgoMatchesPast() {
        return fetchList("https://api.pandascore.co/csgo/matches/past");
    }

    public JsonNode getCsgoMatchesRunning() {
        return fetchList("https://api.pandascore.co/csgo/matches/running");
    }

    public JsonNode getCsgoMatchesUpcoming() {
        return fetchList("https://api.pandascore.co/csgo/matches/upcoming");
    }

    public JsonNode getCsgoMatch(String id) {
        return fetchList("https://api.pandascore.co/csgo/matches/" + id);
    }

    public JsonNode getCsgoPlayerStats() {
        return fetchList("https://api.pandascore.co/csgo/stats/players");
    }

    public JsonNode getCsgoTeamStats() {
        return fetchList("https://api.pandascore.co/csgo/stats/teams");
    }

    public JsonNode getCsgoTournamentStats() {
        return fetchList("https://api.pandascore.co/csgo/stats/tournaments");
    }

    public JsonNode getCsgoPlayers() {
        return fetchList("https://api.pandascore.co/csgo/players");
    }

    public JsonNode getCsgoPlayer(String id) {
        return fetchList("https://api.pandascore.co/csgo/players/" + id);
    }

    public JsonNode getCsgoTeams() {
        return fetchList("https://api.pandascore.co/csgo/teams");
    }

    public JsonNode getCsgoTeam(String id) {
        return fetchList("https://api.pandascore.co/csgo/teams/" + id);
    }

    public JsonNode getCsgoTournaments() {
        return fetchList("https://api.pandascore.co/csgo/tournaments");
    }

    public JsonNode getCsgoTournamentsPast() {
        return fetchList("https://api.pandascore.co/csgo/tournaments/past");
    }

    public JsonNode getCsgoTournamentsRunning() {
        return fetchList("https://api.pandascore.co/csgo/tournaments/running");
    }

    public JsonNode getCsgoTournamentsUpcoming() {
        return fetchList("https://api.pandascore.co/csgo/tournaments/upcoming");
    }

    public JsonNode getCsgoTournament(String id) {
        return fetchList("https://api.pandascore.co/csgo/tournaments/" + id);
    }

    public JsonNode getCsgoWeapons() {
        return fetchList("https://api.pandascore.co/csgo/weapons");
    }

    public JsonNode getCsgoWeapon(String id) {
        return fetchList("https://api.pandascore.co/csgo/weapons/" + id);
    }

    // ----
    public JsonNode getSeries(String id) {
        return fetchList("https://api.pandascore.co/series/" + id);
    }

}
