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

    static String TFT_SUMMONER_URL = "https://na1.api.riotgames.com/tft/summoner/v1/summoners/by-name/%s";
//    static final String URL_EMPLOYEES = "https://americas.api.riotgames.com/tft/match/v1/matches/by-puuid/s5cOG7zcrxL9BWHqedUV65qxt_oyvCGdJ5C1uinMlp356z_y1ztitEl38L0bx7CWEzmtamr23BL2vQ/ids?count=20";

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

    private static String getTftSummonerUrl(String summonerName) {
        return String.format(TFT_SUMMONER_URL, summonerName);
    }

    public static TftSummonerV1 getTFTSummonerInfo(String summonerName) {
        final String uri = getTftSummonerUrl(summonerName);

        // HttpHeaders
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-Riot-Token", riotApiKey);

        // HttpEntity<String>: To get result as String.
        HttpEntity<TftSummonerV1> entity = new HttpEntity<TftSummonerV1>(headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<TftSummonerV1> response = restTemplate.exchange(uri, HttpMethod.GET, entity, TftSummonerV1.class);

        TftSummonerV1 result = response.getBody();

        if (result != null) {
            System.out.println(result.toString());
        }

        return result;
    }
}