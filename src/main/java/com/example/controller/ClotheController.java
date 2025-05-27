package com.example.controller;

import com.example.domain.Clothe;
import com.example.form.ClotheForm;
import com.example.service.ClotheService;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @Autowired
    private ServletContext application;

    @GetMapping("")
    public String index(Model model) {
        Map<Integer, String> colorMap = new LinkedHashMap<>();
        colorMap.put(1, "赤");
        colorMap.put(2, "青");
        colorMap.put(3, "白");
        colorMap.put(4, "黄");
        application.setAttribute("colors", colorMap);
        model.addAttribute("gender", 0); //初期選択
        model.addAttribute("selectedColorKey", 1); //初期選択
        return "clothes/search-clothes";
    }

    @PostMapping("/search")
    public String search(ClotheForm form, Model model) {
        Integer gender = Integer.parseInt(form.getGender());
        Integer color = Integer.parseInt(form.getColor());
        List<Clothe> clothes = service.searchByColorAndGender(color, gender);
        model.addAttribute("clothes", clothes);
        model.addAttribute("hasBeenSearched", true); //検索されたことがあるか？
        model.addAttribute("gender", gender);
        model.addAttribute("selectedColorKey", color);
        return "clothes/search-clothes";
    }

    @GetMapping("/search")
    public String getSearchPage(Model model){
        return index(model);
    }
}
