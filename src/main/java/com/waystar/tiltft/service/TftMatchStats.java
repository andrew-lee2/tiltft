package com.waystar.tiltft.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TftMatchStats {
    @JsonProperty("info")
    private TftMatchStatsInfo info;

    public TftMatchStats() {
    }

    public TftMatchStatsInfo getInfo() {
        return info;
    }

    public void setInfo(TftMatchStatsInfo info) {
        this.info = info;
    }

}

