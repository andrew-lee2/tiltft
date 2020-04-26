package com.waystar.tiltft.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TftMatchStatsInfo {
    @JsonProperty("game_datetime")
    private Long gameDatetime;
    private Float game_length;
    private String game_variation;
    private String game_version;
    @JsonProperty("participants")
    private List<PlayerMatchInfo> participants;

    public Long getGameDatetime() {
        return gameDatetime;
    }

    public void setGameDatetime(Long gameDatetime) {
        this.gameDatetime = gameDatetime;
    }

    public Float getGame_length() {
        return game_length;
    }

    public void setGame_length(Float game_length) {
        this.game_length = game_length;
    }

    public String getGame_variation() {
        return game_variation;
    }

    public void setGame_variation(String game_variation) {
        this.game_variation = game_variation;
    }

    public String getGame_version() {
        return game_version;
    }

    public void setGame_version(String game_version) {
        this.game_version = game_version;
    }

    public List<PlayerMatchInfo> getParticipants()
    {
        return participants;
    }

    public void setParticipants(List<PlayerMatchInfo> participants)
    {
        this.participants = participants;
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

    public Integer getGold_left() {
        return gold_left;
    }

    public void setGold_left(Integer gold_left) {
        this.gold_left = gold_left;
    }

    public Integer getLast_round() {
        return last_round;
    }

    public void setLast_round(Integer last_round) {
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

    public Integer getPlayers_eliminated() {
        return players_eliminated;
    }

    public void setPlayers_eliminated(Integer players_eliminated) {
        this.players_eliminated = players_eliminated;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public Float getTime_eliminated() {
        return time_eliminated;
    }

    public void setTime_eliminated(Float time_eliminated) {
        this.time_eliminated = time_eliminated;
    }
}
