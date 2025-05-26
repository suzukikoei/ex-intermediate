package com.example.controller;

import com.example.domain.Team;
import com.example.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 球団情報を操作するコントローラ
 */
@Controller
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService service;

    @GetMapping("")
    public String index(Model model){
        List<Team> teams = service.showList();
        model.addAttribute("teams", teams);
        return "team-index";
    }

    @PostMapping("/showDetail")
    public String showDetail(String id){
        Integer team_id = Integer.parseInt(id);
        Team team = service.showDetail(team_id);
        if (team == null){
            return "team-error";
        }
        return "teams-info";
    }
}
