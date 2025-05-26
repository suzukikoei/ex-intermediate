package com.example.service;

import com.example.domain.Team;
import com.example.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 球団情報の業務処理を行うサービス.
 */
@Service
@Transactional
public class TeamService {
    @Autowired
    private TeamRepository repository;

    public List<Team> getAllTeams(){
        return repository.findAll();
    }

    public Team getTeamInfo(Integer id){
        return repository.findById(id);
    }

}
