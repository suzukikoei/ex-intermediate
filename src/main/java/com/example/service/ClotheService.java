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

    public List<Clothe> searchByColorAndGender(Integer gender, Integer color_id){
        String color = "";
        switch (color_id){
            case 1:
                color = "赤";
            case 2:
                color = "青";
            case 3:
                color = "白";
            case 4:
                color = "黄";
        }
        return repository.findByColorAndGender(gender,color);
    }

}
