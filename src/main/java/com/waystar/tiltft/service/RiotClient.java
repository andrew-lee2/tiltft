package com.waystar.tiltft.service;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RiotClient
{
//    @Value("${tiltft.riot-api-key}")
    static String riotApiKey = "RGAPI-ccab0c27-6786-4c4b-8787-9670ce98da8b";

    private static String getContinent(String region) {
        String[] americasRegion = {"NA1", "BR1", "LA1", "LA2", "OC1"};
        String[] asiaRegion = {"KR", "JP1"};

        if (Arrays.asList(americasRegion).contains(region)) {
            return "americas";
        } else if (Arrays.asList(asiaRegion).contains(region)) {
            return "asia";
        } else {
            return "europe";
        }

    }

    private static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Riot-Token", riotApiKey);

        return headers;
    }

    private static String getTftSummonerUri(String summonerName, String region) {
        String TFT_SUMMONER_URL = "https://%s.api.riotgames.com/tft/summoner/v1/summoners/by-name/%s";
        return String.format(TFT_SUMMONER_URL, region, summonerName);
    }

    public static TftSummonerV1 getTFTSummonerInfo(String summonerName, String region) {
        final String summonerUri = getTftSummonerUri(summonerName, region);

        HttpHeaders headers = getHttpHeaders();
        HttpEntity<TftSummonerV1> entity = new HttpEntity<TftSummonerV1>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TftSummonerV1> response = restTemplate.exchange(summonerUri, HttpMethod.GET, entity, TftSummonerV1.class);

        return response.getBody();
    }

    private static String getTftSummonerMatchIdsUri(String puuid, Integer count, String region) {
        String TFT_SUMMONER_MATCH_URL = "https://%s.api.riotgames.com/tft/match/v1/matches/by-puuid/%s/ids?count=%d";
        String continent = getContinent(region);
        return String.format(TFT_SUMMONER_MATCH_URL, continent, puuid, count);
    }

    public static String[] getTftSummonerMatchIds(String puuid, String region) {
        final Integer MATCH_COUNT = 10;
        final String matchIdUri = getTftSummonerMatchIdsUri(puuid, MATCH_COUNT, region);

        HttpHeaders headers = getHttpHeaders();
        HttpEntity<TftSummonerMatchIds> entity = new HttpEntity<TftSummonerMatchIds>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String[]> response = restTemplate.exchange(matchIdUri, HttpMethod.GET, entity, String[].class);

        return response.getBody();
    }

    private static String getTftMatchInfoUri(String matchId, String region) {
        String TFT_MATCH_URL = "https://%s.api.riotgames.com/tft/match/v1/matches/%s";
        String continent = getContinent(region);
        return String.format(TFT_MATCH_URL, continent, matchId);
    }

    public static TftMatchStats getTftMatchInfo(String matchId, String region) {
        final String matchIdUri = getTftMatchInfoUri(matchId, region);

        HttpHeaders headers = getHttpHeaders();
        HttpEntity<TftMatchStats> entity = new HttpEntity<TftMatchStats>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TftMatchStats> response = restTemplate.exchange(matchIdUri, HttpMethod.GET, entity, TftMatchStats.class);

        return response.getBody();
    }
}