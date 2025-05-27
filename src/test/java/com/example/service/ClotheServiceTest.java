package com.example.service;

import com.example.domain.Clothe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClotheServiceTest {
    @Autowired
    private ClotheService service;

    @Test
    void searchByColorAndGender1() {
        List<Clothe> actualClothes = service.searchByColorAndGender(1, 0);
        assertEquals("ジャケット", actualClothes.getFirst().getGenre(), "genre: 期待された結果と異なります");
        assertEquals(10000, actualClothes.getFirst().getPrice(), "price: 期待された結果と異なります");
    }

    @Test
    void searchByColorAndGender2() {
        List<Clothe> actualClothes = service.searchByColorAndGender(2, 1);
        assertEquals(3, actualClothes.size(), "count: 期待された結果と異なります");
    }


    @Test
    void searchByColorAndGender3() {
        List<Clothe> actualClothes = service.searchByColorAndGender(1, 1);
        assertEquals(0, actualClothes.size(), "count: 期待された結果と異なります");
    }

}