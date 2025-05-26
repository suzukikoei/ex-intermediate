package com.example.controller;

import com.example.domain.Team;
import com.example.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 球団情報を操作するコントローラ
 */
@Controller
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService service;

    /**
     * 球団一覧画面を表示する.
     *
     * @param model
     * @return 球団一覧画面
     */
    @GetMapping("")
    public String index(Model model){
        List<Team> teams = service.showList();
        model.addAttribute("teams", teams);
        return "teams/teams-index";
    }

    /**
     * 球団詳細画面を表示する.
     *
     * @param id 球団id
     * @param model リクエストスコープ
     * @return 球団詳細画面
     */
    @GetMapping("/showDetail")
    public String showDetail(Integer id, Model model){
        Team team = service.showDetail(id);
        if (team == null){
            return "teams/team-error";
        }
        model.addAttribute("teamInfo", team);
        return "teams/team-info";
    }
}
