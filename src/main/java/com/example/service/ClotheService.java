package com.example.service;

import com.example.domain.Clothe;
import com.example.repository.ClotheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 衣類の情報を操作し、業務処理を行うサービス.
 */
@Service
@Transactional
public class ClotheService {
    @Autowired
    private ClotheRepository repository;

    /**
     * 色と性別で衣類検索をする.
     *
     * @param color_id 色を表す数
     * @param gender 性別
     * @return 衣類の一覧
     */
    public List<Clothe> searchByColorAndGender(Integer color_id, Integer gender){
        String color = "";
        switch (color_id){
            case 1:
                color = "赤";
                break;
            case 2:
                color = "青";
                break;
            case 3:
                color = "白";
                break;
            case 4:
                color = "黄";
                break;
        }
        return repository.findByColorAndGender(color, gender);
    }

}
