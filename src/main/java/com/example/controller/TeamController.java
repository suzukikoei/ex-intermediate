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

    @GetMapping("")
    public String index(Model model){
        List<Team> teams = service.showList();
        model.addAttribute("teams", teams);
        return "teams-index";
    }

    @GetMapping("/showDetail")
    public String showDetail(Integer id, Model model){
        Team team = service.showDetail(id);
        if (team == null){
            return "team-error";
        }
        model.addAttribute("teamInfo", team);
        return "team-info";
    }
}
