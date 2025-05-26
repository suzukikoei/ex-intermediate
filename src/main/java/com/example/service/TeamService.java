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

    /**
     * 球団一覧を全権検索する.
     *
     * @return
     */
    public List<Team> showList(){
        return repository.findAll();
    }

    /**
     * 球団をidで一件検索する.
     *
     * @param id 球団id
     * @return 球団情報
     */
    public Team showDetail(Integer id){
        return repository.findById(id);
    }

}
