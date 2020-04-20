package com.waystar.tiltft.service;
import com.waystar.tiltft.service.TftSummonerV1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RiotClient
{
//    @Value("${tiltft.riot-api-key}")
    static String riotApiKey = "RGAPI-95b3d2fa-688d-40e9-a986-d1b12a2108d5";

//    FIXME do something with the singleton
//    FIXME maybe do some kind of automatic api?
    private RiotClient()
    {

    }

    // Inner class to provide instance of class
    private static class BillPughSingleton
    {
        private static final RiotClient INSTANCE = new RiotClient();
    }

    public static RiotClient getInstance()
    {
        return BillPughSingleton.INSTANCE;
    }

    private static String getTftSummonerUri(String summonerName) {
        String TFT_SUMMONER_URL = "https://na1.api.riotgames.com/tft/summoner/v1/summoners/by-name/%s";
        return String.format(TFT_SUMMONER_URL, summonerName);
    }

    public static TftSummonerV1 getTFTSummonerInfo(String summonerName) {
        final String summonerUri = getTftSummonerUri(summonerName);

        // HttpHeaders
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Riot-Token", riotApiKey);

        // HttpEntity<String>: To get result as String.
        HttpEntity<TftSummonerV1> entity = new HttpEntity<TftSummonerV1>(headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<TftSummonerV1> response = restTemplate.exchange(summonerUri, HttpMethod.GET, entity, TftSummonerV1.class);

        TftSummonerV1 result = response.getBody();

        if (result != null) {
            System.out.println(result.toString());
        }

        return result;
    }

    private static String getTftSummonerMatchIdsUri(String puuid, Integer count) {
        String TFT_SUMMONER_MATCH_URL = "https://americas.api.riotgames.com/tft/match/v1/matches/by-puuid/%s/ids?count=%d";
        return String.format(TFT_SUMMONER_MATCH_URL, puuid, count);
    }

    private static HttpEntity getHttpEntity(Object dataClass) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Riot-Token", riotApiKey);

        return new HttpEntity<dataClass>(headers);
    }

    public static TftSummonerMatchIds getTftSummonerMatchIds(String puuid) {
        final Integer MATCH_COUNT = 20;
        final String matchIdUri = getTftSummonerMatchIdsUri(puuid, MATCH_COUNT);

        // HttpHeaders

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<TftSummonerMatchIds> response = restTemplate.exchange(matchIdUri, HttpMethod.GET, entity, TftSummonerMatchIds.class);

        TftSummonerMatchIds result = response.getBody();

        if (result != null) {
            System.out.println(result.toString());
        }

        return result;
    }
}