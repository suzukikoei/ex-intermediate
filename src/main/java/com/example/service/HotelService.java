package com.example.service;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * ホテル情報を操作するサービス.
 */
@Service
@Transactional
public class HotelService {
    @Autowired
    private HotelRepository repository;

    public List<Hotel> searchByLessThanPrice(String price){
        if(price.equals("")){
            return repository.findAll();
        }
        return repository.findByPrice(Integer.parseInt(price));
    }


}
