package com.example.service;

import com.example.domain.Team;
import com.example.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeamServiceTest {

    @Autowired
    private TeamService service;

    @Autowired
    private TeamRepository repository;

    @Test
    void testShowList(){
        List<Team> actualTeams = service.showList();
        assertEquals(6, actualTeams.size(), "count: 期待された件数と異なります");
        assertEquals("読売ジャイアンツ", actualTeams.getFirst().getTeamName(), "teamName: 期待された結果と異なります");
    }

    @Test
    void testShowDetail1() {
//        when(repository.findById(1))
//                .thenReturn(new Team(1, "セントラル・リーグ","読売ジャイアンツ","東京ドーム（東京都・文京区）","1934年12月26日","大日本東京野球倶楽部（1934年）↓ 東京巨人軍（1935年〜1946年）↓ 読売ジャイアンツ（1947年〜）"));

        Team actualTeam = service.showDetail(1);

        Team expectedTeam = new Team(1, "セントラル・リーグ","読売ジャイアンツ","東京ドーム（東京都・文京区）","1934年12月26日","大日本東京野球倶楽部（1934年）↓ 東京巨人軍（1935年〜1946年）↓ 読売ジャイアンツ（1947年〜）");

        assertEquals(expectedTeam.getId(), actualTeam.getId(), "id: 期待された結果と異なります");
        assertEquals(expectedTeam.getLeagueName(), actualTeam.getLeagueName(), "leagueName: 期待された結果と異なります");
        assertEquals(expectedTeam.getTeamName(), actualTeam.getTeamName(), "teamName: 期待された結果と異なります");
        assertEquals(expectedTeam.getHeadQuarters(), actualTeam.getHeadQuarters(), "headquarters: 期待された結果と異なります");
        assertEquals(expectedTeam.getInauguration(), actualTeam.getInauguration(), "inauguration: 期待された結果と異なります");
    }

    @Test
    void testShowDetail2(){
        Team actualTeam = service.showDetail(100);
        assertNull(actualTeam, "isNull: 期待された結果と異なります");
    }
}