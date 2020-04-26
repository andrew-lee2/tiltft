package com.waystar.tiltft.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TftMatchStatsInfo {
    private Long game_datetime;
    private Float game_length;
    private String game_variation;
    private String game_version;
    private PlayerMatchInfo[] participants;

    public Long getGameDatetime() {
        return game_datetime;
    }

    public void setGameDatetime(Long game_datetime) {
        this.game_datetime = game_datetime;
    }

    public Float getGameLength() {
        return game_length;
    }

    public void setGameLength(Float game_length) {
        this.game_length = game_length;
    }

    public String getGameVariation() {
        return game_variation;
    }

    public void setGameVariation(String game_variation) {
        this.game_variation = game_variation;
    }

    public String getGameVersion() {
        return game_version;
    }

    public void setGameVersion(String game_version) {
        this.game_version = game_version;
    }

    public PlayerMatchInfo getPlayerMatchInfo(int index)
    {
        return participants[index];
    }

    public void setPlayerMatchInfo(PlayerMatchInfo newPlayerMatchInfo, int index)
    {
        participants[index] = newPlayerMatchInfo;
    }
}


@JsonIgnoreProperties(ignoreUnknown = true)
class PlayerMatchInfo {
    private Integer gold_left;
    private Integer last_round;
    private Integer level;
    private Integer placement;
    private Integer players_eliminated;
    private String puuid;
    private Float time_eliminated;

    public Integer getGoldLeft() {
        return gold_left;
    }

    public void setGoldLeft(Integer gold_left) {
        this.gold_left = gold_left;
    }

    public Integer getLast_round() {
        return last_round;
    }

    public void setLastRound(Integer last_round) {
        this.last_round = last_round;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPlacement() {
        return placement;
    }

    public void setPlacement(Integer placement) {
        this.placement = placement;
    }

    public Integer getPlayersEliminated() {
        return players_eliminated;
    }

    public void setPlayersEliminated(Integer players_eliminated) {
        this.players_eliminated = players_eliminated;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public Float getTimeEliminated() {
        return time_eliminated;
    }

    public void setTimeEliminated(Float time_eliminated) {
        this.time_eliminated = time_eliminated;
    }
}
