package com.example.service;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HotelServiceTest {
    @Autowired
    private HotelService service;
//
//    @Autowired
//    private HotelRepository repository;

    @Test
    void searchByLessThanPrice1() {
        List<Hotel> actualHotels = service.searchByLessThanPrice("");
        assertEquals(5, actualHotels.size(), "count: 期待された結果と異なります");
    }

    @Test
    void searchByLessThanPrice2() {
        List<Hotel> actualHotels = service.searchByLessThanPrice("4999");
        assertEquals(0, actualHotels.size(), "count: 期待された結果と異なります");
    }

    @Test
    void searchByLessThanPrice3() {
        List<Hotel> actualHotels = service.searchByLessThanPrice("5000");
        assertEquals(1, actualHotels.size(), "count: 期待された結果と異なります");
    }

    @Test
    void searchByLessThanPrice4() {
        List<Hotel> actualHotels = service.searchByLessThanPrice("9999");
        assertEquals(1, actualHotels.size(), "count: 期待された結果と異なります");
    }

    @Test
    void searchByLessThanPrice5() {
        List<Hotel> actualHotels = service.searchByLessThanPrice("10000");
        assertEquals(3, actualHotels.size(), "count: 期待された結果と異なります");
    }
}