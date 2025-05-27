package com.example.controller;

import com.example.domain.Clothe;
import com.example.form.ClotheForm;
import com.example.service.ClotheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 衣類の情報を操作するコントローラ.
 */
@Controller
@RequestMapping("/searchClothes")
public class ClotheController {
    @Autowired
    private ClotheService service;

    @GetMapping("")
    public String index(Model model) {
        Map<Integer, String> colorMap = new LinkedHashMap<>();
        colorMap.put(1, "赤");
        colorMap.put(2, "青");
        colorMap.put(3, "白");
        colorMap.put(4, "黄");
        model.addAttribute("colors", colorMap);
        return "clothes/search-clothes";
    }

    @PostMapping("/search")
    public String search(ClotheForm form, Model model) {
        Integer gender = form.getGender();
        Integer color = form.getColor();
        List<Clothe> clothes = service.searchByColorAndGender(gender, color);
        model.addAttribute("clothes", clothes);
        return "clothes/search-clothes";
    }


}
