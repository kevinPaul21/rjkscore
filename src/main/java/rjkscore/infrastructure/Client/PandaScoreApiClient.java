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

    // --- DOTA2 endpoints ---
    public JsonNode getDota2Abilities() {
        return fetchList("https://api.pandascore.co/dota2/abilities");
    }

    public JsonNode getDota2Ability(String id) {
        return fetchList("https://api.pandascore.co/dota2/abilities/" + id);
    }

    public JsonNode getDota2Game(String id) {
        return fetchList("https://api.pandascore.co/dota2/games/" + id);
    }

    public JsonNode getDota2Heroes() {
        return fetchList("https://api.pandascore.co/dota2/heroes");
    }

    public JsonNode getDota2Hero(String id) {
        return fetchList("https://api.pandascore.co/dota2/heroes/" + id);
    }

    public JsonNode getDota2Items() {
        return fetchList("https://api.pandascore.co/dota2/items");
    }

    public JsonNode getDota2Item(String id) {
        return fetchList("https://api.pandascore.co/dota2/items/" + id);
    }

    public JsonNode getDota2Leagues() {
        return fetchList("https://api.pandascore.co/dota2/leagues");
    }

    public JsonNode getDota2Matches() {
        return fetchList("https://api.pandascore.co/dota2/matches");
    }

    public JsonNode getDota2MatchesPast() {
        return fetchList("https://api.pandascore.co/dota2/matches/past");
    }

    public JsonNode getDota2MatchesRunning() {
        return fetchList("https://api.pandascore.co/dota2/matches/running");
    }

    public JsonNode getDota2MatchesUpcoming() {
        return fetchList("https://api.pandascore.co/dota2/matches/upcoming");
    }

    public JsonNode getDota2Match(String id) {
        return fetchList("https://api.pandascore.co/dota2/matches/" + id);
    }

    public JsonNode getDota2Players() {
        return fetchList("https://api.pandascore.co/dota2/players");
    }

    public JsonNode getDota2Player(String id) {
        return fetchList("https://api.pandascore.co/dota2/players/" + id);
    }

    public JsonNode getDota2Series() {
        return fetchList("https://api.pandascore.co/dota2/series");
    }

    public JsonNode getDota2SeriesPast() {
        return fetchList("https://api.pandascore.co/dota2/series/past");
    }

    public JsonNode getDota2SeriesRunning() {
        return fetchList("https://api.pandascore.co/dota2/series/running");
    }

    public JsonNode getDota2SeriesUpcoming() {
        return fetchList("https://api.pandascore.co/dota2/series/upcoming");
    }

    public JsonNode getDota2SeriesTeams(String id) {
        return fetchList("https://api.pandascore.co/dota2/series/" + id + "/teams");
    }

    public JsonNode getDota2Teams() {
        return fetchList("https://api.pandascore.co/dota2/teams");
    }

    public JsonNode getDota2Team(String id) {
        return fetchList("https://api.pandascore.co/dota2/teams/" + id);
    }

    public JsonNode getDota2Tournaments() {
        return fetchList("https://api.pandascore.co/dota2/tournaments");
    }

    public JsonNode getDota2TournamentsPast() {
        return fetchList("https://api.pandascore.co/dota2/tournaments/past");
    }

    public JsonNode getDota2TournamentsRunning() {
        return fetchList("https://api.pandascore.co/dota2/tournaments/running");
    }

    public JsonNode getDota2TournamentsUpcoming() {
        return fetchList("https://api.pandascore.co/dota2/tournaments/upcoming");
    }

    public JsonNode getDota2Tournament(String id) {
        return fetchList("https://api.pandascore.co/dota2/tournaments/" + id);
    }

    // --- LOL endpoints ---
    public JsonNode getLolChampions() {
        return fetchList("https://api.pandascore.co/lol/champions");
    }

    public JsonNode getLolChampion(String id) {
        return fetchList("https://api.pandascore.co/lol/champions/" + id);
    }

    public JsonNode getLolItems() {
        return fetchList("https://api.pandascore.co/lol/items");
    }

    public JsonNode getLolItem(String id) {
        return fetchList("https://api.pandascore.co/lol/items/" + id);
    }

    public JsonNode getLolLeagues() {
        return fetchList("https://api.pandascore.co/lol/leagues");
    }

    public JsonNode getLolMasteries() {
        return fetchList("https://api.pandascore.co/lol/masteries");
    }

    public JsonNode getLolMastery(String id) {
        return fetchList("https://api.pandascore.co/lol/masteries/" + id);
    }

    public JsonNode getLolMatches() {
        return fetchList("https://api.pandascore.co/lol/matches");
    }

    public JsonNode getLolMatchesPast() {
        return fetchList("https://api.pandascore.co/lol/matches/past");
    }

    public JsonNode getLolMatchesRunning() {
        return fetchList("https://api.pandascore.co/lol/matches/running");
    }

    public JsonNode getLolMatchesUpcoming() {
        return fetchList("https://api.pandascore.co/lol/matches/upcoming");
    }

    public JsonNode getLolMatch(String id) {
        return fetchList("https://api.pandascore.co/lol/matches/" + id);
    }

    public JsonNode getLolPlayers() {
        return fetchList("https://api.pandascore.co/lol/players");
    }

    public JsonNode getLolPlayer(String id) {
        return fetchList("https://api.pandascore.co/lol/players/" + id);
    }

    public JsonNode getLolRunesReforged() {
        return fetchList("https://api.pandascore.co/lol/runes-reforged");
    }

    public JsonNode getLolRunesReforgedPaths() {
        return fetchList("https://api.pandascore.co/lol/runes-reforged-paths");
    }

    public JsonNode getLolRunesReforgedPath(String id) {
        return fetchList("https://api.pandascore.co/lol/runes-reforged-paths/" + id);
    }

    public JsonNode getLolRuneReforged(String id) {
        return fetchList("https://api.pandascore.co/lol/runes-reforged/" + id);
    }

    public JsonNode getLolSeries() {
        return fetchList("https://api.pandascore.co/lol/series");
    }

    public JsonNode getLolSeriesPast() {
        return fetchList("https://api.pandascore.co/lol/series/past");
    }

    public JsonNode getLolSeriesRunning() {
        return fetchList("https://api.pandascore.co/lol/series/running");
    }

    public JsonNode getLolSeriesUpcoming() {
        return fetchList("https://api.pandascore.co/lol/series/upcoming");
    }

    public JsonNode getLolSeriesTeams(String id) {
        return fetchList("https://api.pandascore.co/lol/series/" + id + "/teams");
    }

    public JsonNode getLolTeams() {
        return fetchList("https://api.pandascore.co/lol/teams");
    }

    public JsonNode getLolTeam(String id) {
        return fetchList("https://api.pandascore.co/lol/teams/" + id);
    }

    public JsonNode getLolSpells() {
        return fetchList("https://api.pandascore.co/lol/spells");
    }

    public JsonNode getLolSpell(String id) {
        return fetchList("https://api.pandascore.co/lol/spells/" + id);
    }

    public JsonNode getLolTournaments() {
        return fetchList("https://api.pandascore.co/lol/tournaments");
    }

    public JsonNode getLolTournament(String id) {
        return fetchList("https://api.pandascore.co/lol/tournaments/" + id);
    }

    public JsonNode getLolTournamentsPast() {
        return fetchList("https://api.pandascore.co/lol/tournaments/past");
    }

    public JsonNode getLolTournamentsRunning() {
        return fetchList("https://api.pandascore.co/lol/tournaments/running");
    }

    public JsonNode getLolTournamentsUpcoming() {
        return fetchList("https://api.pandascore.co/lol/tournaments/upcoming");
    }

    // --- VALORANT endpoints ---
    public JsonNode getValorantAbilities() {
        return fetchList("https://api.pandascore.co/valorant/abilities");
    }

    public JsonNode getValorantAbility(String id) {
        return fetchList("https://api.pandascore.co/valorant/abilities/" + id);
    }

    public JsonNode getValorantAgents() {
        return fetchList("https://api.pandascore.co/valorant/agents");
    }

    public JsonNode getValorantAgent(String id) {
        return fetchList("https://api.pandascore.co/valorant/agents/" + id);
    }

    public JsonNode getValorantLeagues() {
        return fetchList("https://api.pandascore.co/valorant/leagues");
    }

    public JsonNode getValorantMaps() {
        return fetchList("https://api.pandascore.co/valorant/maps");
    }

    public JsonNode getValorantMap(String id) {
        return fetchList("https://api.pandascore.co/valorant/maps/" + id);
    }

    public JsonNode getValorantMatches() {
        return fetchList("https://api.pandascore.co/valorant/matches");
    }

    public JsonNode getValorantMatchesPast() {
        return fetchList("https://api.pandascore.co/valorant/matches/past");
    }

    public JsonNode getValorantMatchesRunning() {
        return fetchList("https://api.pandascore.co/valorant/matches/running");
    }

    public JsonNode getValorantMatchesUpcoming() {
        return fetchList("https://api.pandascore.co/valorant/matches/upcoming");
    }

    public JsonNode getValorantPlayers() {
        return fetchList("https://api.pandascore.co/valorant/players");
    }

    public JsonNode getValorantSeries() {
        return fetchList("https://api.pandascore.co/valorant/series");
    }

    public JsonNode getValorantSeriesPast() {
        return fetchList("https://api.pandascore.co/valorant/series/past");
    }

    public JsonNode getValorantSeriesRunning() {
        return fetchList("https://api.pandascore.co/valorant/series/running");
    }

    public JsonNode getValorantSeriesUpcoming() {
        return fetchList("https://api.pandascore.co/valorant/series/upcoming");
    }

    public JsonNode getValorantTeams() {
        return fetchList("https://api.pandascore.co/valorant/teams");
    }

    public JsonNode getValorantTournaments() {
        return fetchList("https://api.pandascore.co/valorant/tournaments");
    }

    public JsonNode getValorantTournamentsPast() {
        return fetchList("https://api.pandascore.co/valorant/tournaments/past");
    }

    public JsonNode getValorantTournamentsRunning() {
        return fetchList("https://api.pandascore.co/valorant/tournaments/running");
    }

    public JsonNode getValorantTournamentsUpcoming() {
        return fetchList("https://api.pandascore.co/valorant/tournaments/upcoming");
    }

    public JsonNode getValorantWeapons() {
        return fetchList("https://api.pandascore.co/valorant/weapons");
    }

    public JsonNode getValorantWeapon(String id) {
        return fetchList("https://api.pandascore.co/valorant/weapons/" + id);
    }

}
