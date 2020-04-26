package com.waystar.tiltft.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TftMatchStatsInfo {
    @JsonProperty("game_datetime")
    private Long gameDatetime;
    @JsonProperty("game_length")
    private Float gameLength;
    @JsonProperty("game_variation")
    private String gameVariation;
    @JsonProperty("game_version")
    private String gameVersion;
    private List<PlayerMatchInfo> participants;

    public Long getGameDatetime() {
        return gameDatetime;
    }

    public void setGameDatetime(Long gameDatetime) {
        this.gameDatetime = gameDatetime;
    }

    public Float getGameLength() {
        return gameLength;
    }

    public void setGameLength(Float gameLength) {
        this.gameLength = gameLength;
    }

    public String getGameVariation() {
        return gameVariation;
    }

    public void setGameVariation(String gameVariation) {
        this.gameVariation = gameVariation;
    }

    public String getGameVersion() {
        return gameVersion;
    }

    public void setGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
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
    @JsonProperty("gold_left")
    private Integer goldLeft;
    @JsonProperty("last_round")
    private Integer lastRound;
    private Integer level;
    private Integer placement;
    @JsonProperty("players_eliminated")
    private Integer playersEliminated;
    private String puuid;
    @JsonProperty("time_eliminated")
    private Float timeEliminated;

    public Integer getGoldLeft() {
        return goldLeft;
    }

    public void setGoldLeft(Integer goldLeft) {
        this.goldLeft = goldLeft;
    }

    public Integer getLastRound() {
        return lastRound;
    }

    public void setLastRound(Integer lastRound) {
        this.lastRound = lastRound;
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
        return playersEliminated;
    }

    public void setPlayersEliminated(Integer playersEliminated) {
        this.playersEliminated = playersEliminated;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public Float getTimeEliminated() {
        return timeEliminated;
    }

    public void setTimeEliminated(Float timeEliminated) {
        this.timeEliminated = timeEliminated;
    }
}
