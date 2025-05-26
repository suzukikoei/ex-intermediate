package com.example.domain;

import java.util.Date;

/**
 * 球団ドメイン.
 */
public class Team {
    /** 球団id */
    private Integer id;
    /** 球団リーグ名 */
    private String leagueName;
    /** 球団名 */
    private String teamName;
    /** 球団本拠地 */
    private String headQuarters;
    /** 球団発足年月日 */
    private String inauguration;
    /** 球団名の変遷 */
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
