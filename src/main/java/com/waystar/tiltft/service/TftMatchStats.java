package com.waystar.tiltft.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TftMatchStats {
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

