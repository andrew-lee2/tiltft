package com.waystar.tiltft.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TftSummonerV1 {
    private String id;
    private String accountId;
    private String puuid;
    private String name;
    private String profileIconId;
    private Long revisionDate;
    private Integer summonerLevel;

    public TftSummonerV1() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(String profileIconId) {
        this.profileIconId = profileIconId;
    }

    public Long getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Long revisionDate) {
        this.revisionDate = revisionDate;
    }

    public Integer getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(Integer summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    @Override
    public String toString() {
        return "TftSummonerV1{" +
                "id='" + id + '\'' +
                ", accountId=" + accountId + '\'' +
                ", puuid=" + puuid + '\'' +
                ", name=" + name + '\'' +
                ", profileIconId=" + profileIconId + '\'' +
                ", revisionDate=" + revisionDate + '\'' +
                ", summonerLevel=" + summonerLevel + '\'' +
                '}';
    }
}
