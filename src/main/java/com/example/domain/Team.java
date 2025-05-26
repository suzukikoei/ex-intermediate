package com.example.domain;

import java.util.Date;

/**
 * 球団ドメイン.
 */
public class Team {
    private Integer id;
    private String leagueName;
    private String teamName;
    private String headQuarters;
    private String inauguration;
    private String history;

    public Team() {}

    public Team(Integer id, String leagueName, String teamName, String headQuarters, String inauguration, String history) {
        this.id = id;
        this.leagueName = leagueName;
        this.teamName = teamName;
        this.headQuarters = headQuarters;
        this.inauguration = inauguration;
        this.history = history;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getHeadQuarters() {
        return headQuarters;
    }

    public void setHeadQuarters(String headQuarters) {
        this.headQuarters = headQuarters;
    }

    public String getInauguration() {
        return inauguration;
    }

    public void setInauguration(String inauguration) {
        this.inauguration = inauguration;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "team{" +
                "id=" + id +
                ", leagueName='" + leagueName + '\'' +
                ", teamName='" + teamName + '\'' +
                ", headQuarters='" + headQuarters + '\'' +
                ", inauguration=" + inauguration +
                ", history='" + history + '\'' +
                '}';
    }
}
