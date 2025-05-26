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

@Controller
@RequestMapping("/searchHotels")
public class HotelController {
    @Autowired
    private HotelService service;

    @GetMapping("")
    public String index(HotelForm form){
        return "search-hotels";
    }

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
        return "search-hotels";
    }




}
