package com.waystar.tiltft.service;

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
    static String riotApiKey = "RGAPI-23c452c6-b6db-4bef-adea-6d2a4bff1b4b";

    private static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Riot-Token", riotApiKey);

        return headers;
    }

    private static String getTftSummonerUri(String summonerName) {
        String TFT_SUMMONER_URL = "https://na1.api.riotgames.com/tft/summoner/v1/summoners/by-name/%s";
        return String.format(TFT_SUMMONER_URL, summonerName);
    }

    public static TftSummonerV1 getTFTSummonerInfo(String summonerName) {
        final String summonerUri = getTftSummonerUri(summonerName);

        HttpHeaders headers = getHttpHeaders();
        HttpEntity<TftSummonerV1> entity = new HttpEntity<TftSummonerV1>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TftSummonerV1> response = restTemplate.exchange(summonerUri, HttpMethod.GET, entity, TftSummonerV1.class);

        return response.getBody();
    }

    private static String getTftSummonerMatchIdsUri(String puuid, Integer count) {
        String TFT_SUMMONER_MATCH_URL = "https://americas.api.riotgames.com/tft/match/v1/matches/by-puuid/%s/ids?count=%d";
        return String.format(TFT_SUMMONER_MATCH_URL, puuid, count);
    }

    public static String[] getTftSummonerMatchIds(String puuid) {
        final Integer MATCH_COUNT = 10;
        final String matchIdUri = getTftSummonerMatchIdsUri(puuid, MATCH_COUNT);

        HttpHeaders headers = getHttpHeaders();
        HttpEntity<TftSummonerMatchIds> entity = new HttpEntity<TftSummonerMatchIds>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String[]> response = restTemplate.exchange(matchIdUri, HttpMethod.GET, entity, String[].class);

        return response.getBody();
    }

    private static String getTftMatchInfoUri(String matchId) {
        String TFT_MATCH_URL = "https://americas.api.riotgames.com/tft/match/v1/matches/%s";
        return String.format(TFT_MATCH_URL, matchId);
    }

    public static TftMatchStats getTftMatchInfo(String matchId) {
        final String matchIdUri = getTftMatchInfoUri(matchId);

        HttpHeaders headers = getHttpHeaders();
        HttpEntity<TftMatchStats> entity = new HttpEntity<TftMatchStats>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TftMatchStats> response = restTemplate.exchange(matchIdUri, HttpMethod.GET, entity, TftMatchStats.class);

        return response.getBody();
    }
}