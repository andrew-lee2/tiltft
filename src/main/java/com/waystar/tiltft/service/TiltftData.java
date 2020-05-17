package com.waystar.tiltft.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//TODO make a class for the return type of the data?
public class TiltftData {
    public static Map<Long, PlayerMatchInfo> getTiltftSummonerHistory(String summonerName) {
        TftSummonerV1 summonerData = RiotClient.getTFTSummonerInfo(summonerName);
        String summonerPuuid = summonerData.getPuuid();

        String[] matchIds = RiotClient.getTftSummonerMatchIds(summonerPuuid);

        Map<Long, PlayerMatchInfo> summonerHistory = new HashMap<>();
        for (String matchId : matchIds) {

            TftMatchStats matchStats = RiotClient.getTftMatchInfo(matchId);
            TftMatchStatsInfo matchStatInfo = matchStats.getInfo();
            List<PlayerMatchInfo> playerMatchInfo = matchStatInfo.getParticipants();

            for (PlayerMatchInfo info : playerMatchInfo) {
                if (info.getPuuid().equals(summonerPuuid)) {
                    summonerHistory.put(matchStatInfo.getGameDatetime(), info);
                }
            }
        }

        return summonerHistory;
    }

    public static Double getTiltftRating(String summonerName) {
        Map<Long, PlayerMatchInfo> summonerHistory = TiltftData.getTiltftSummonerHistory(summonerName);

//        TODO make map with key being date and value being place?
        Map<Long, Integer> summonerFinishes = new TreeMap<>();
        for (Map.Entry<Long, PlayerMatchInfo> matchHistory : summonerHistory.entrySet()) {

            PlayerMatchInfo matchInfo = matchHistory.getValue();
            summonerFinishes.put(matchHistory.getKey(), matchInfo.getPlacement());
        }
        
        ArrayList<Integer> initialPlacement = new ArrayList<>();
        ArrayList<Integer> latestPlacement = new ArrayList<>();
        int counter = 0;

        for (Map.Entry<Long, Integer> finish : summonerFinishes.entrySet()) {
            Integer finishValue = finish.getValue();
            if (counter < summonerFinishes.size() / 2) {
                initialPlacement.add(finishValue);
            } else {
                latestPlacement.add(finishValue);
            }
            counter += 1;
        }

//        TODO need to come out with raiting break downs
        return TiltftData.calculateRating(initialPlacement, latestPlacement);
    }
    
    public static Double calculateRating(ArrayList<Integer> initialPlacement, ArrayList<Integer> latestPlacement) {
        Double initialAvg = TiltftData.calculateAverage(initialPlacement);
        Double latestlAvg = TiltftData.calculateAverage(latestPlacement);

        return initialAvg - latestlAvg;
    }

    private static double calculateAverage(List<Integer> placements) {
        Integer sum = 0;
        if(!placements.isEmpty()) {
            for (Integer placement : placements) {
                sum += placement;
            }
            return sum.doubleValue() / placements.size();
        }
        return sum;
    }
}
