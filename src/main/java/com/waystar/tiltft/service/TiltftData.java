package com.waystar.tiltft.service;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//TODO make a class for the return type of the data?
public class TiltftData {
    public static String getTiltftSummonerHistory(String summonerName) {
        TftSummonerV1 summonerData = RiotClient.getTFTSummonerInfo(summonerName);
        String summonerPuuid = summonerData.getPuuid();

        TftSummonerMatchIds matchIds = RiotClient.getTftSummonerMatchIds(summonerPuuid);

        Map<String, TftMatchStatsInfo> summonerHistory = new HashMap<String, TftMatchStats>(;
        //    TODO need to store this in some kind of data struct
        for (String matchId : matchIds.getSummonerMatchIds()) {

            TftMatchStats matchStats = RiotClient.getTftMatchInfo(matchId);
            summonerHistory.put(matchId, matchStats.getInfo());
        }

    }
}
