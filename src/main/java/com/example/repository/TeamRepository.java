package com.example.repository;

import com.example.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 球団情報を操作するリポジトリ.
 */
@Repository
public class TeamRepository {
    private static final RowMapper<Team> TEAM_ROW_MAPPER  =
            (rs, i) -> {
        Team team = new Team();
        team.setId(rs.getInt("id"));
        team.setLeagueName(rs.getString("league_name"));
        team.setTeamName(rs.getString("team_name"));
        team.setHeadQuarters(rs.getString("headquarters"));
        team.setInauguration(rs.getString("inauguration"));
        team.setHistory(rs.getString("history"));
        return team;
            };

    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * 球団情報を全件検索する.
     *
     * @return 球団情報の一覧
     */
    public List<Team> findAll(){
        String sql = "SELECT id" +
                ", league_name" +
                ", team_name" +
                ", headquarters" +
                ", inauguration" +
                ", history" +
                " FROM teams ORDER BY inauguration;";
        return template.query(sql, TEAM_ROW_MAPPER);
    }

    /**
     * 球団情報を一件検索する.
     *
     * @param id 球団のid
     * @return 球団情報
     */
    public Team findById(Integer id){
        String sql =  "SELECT id" +
                ", league_name" +
                ", team_name" +
                ", headquarters" +
                ", inauguration" +
                ", history" +
                " FROM teams WHERE id = :id";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        List<Team> teams = template.query(sql, param, TEAM_ROW_MAPPER);
        if(teams.isEmpty()){
            return null;
        }
        return teams.getFirst();
    }

}
