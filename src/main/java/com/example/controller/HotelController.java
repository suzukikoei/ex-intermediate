package com.example.controller;

import com.example.domain.Hotel;
import com.example.form.HotelForm;
import com.example.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ホテル情報を操作するコントローラ.
 */
@Controller
@RequestMapping("/searchHotels")
public class HotelController {
    @Autowired
    private HotelService service;

    /**
     * ホテル検索画面を表示する.
     *
     * @param form 価格入力フォーム
     * @return ホテル検索結果
     */
    @GetMapping("")
    public String index(HotelForm form){
        return "hotels/search-hotels";
    }

    /**
     * 価格を入力してホテルを検索する.
     *
     * @param form 価格フォーム
     * @param result バリデーション結果
     * @param model リクエストスコープ
     * @return　ホテル検索結果
     */
    @PostMapping("/search")
    public String search(
            @Validated HotelForm form
            , BindingResult result
            , Model model
            ){
        if(result.hasErrors()){
            return index(form);
        }
        List<Hotel> hotels = service.searchByLessThanPrice(form.getPrice());
        model.addAttribute("hotels", hotels);
        model.addAttribute("searchedFlag", 1);
        return "hotels/search-hotels";
    }




}
