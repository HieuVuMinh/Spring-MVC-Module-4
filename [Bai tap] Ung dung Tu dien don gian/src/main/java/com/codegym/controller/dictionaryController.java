package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class dictionaryController {
    @GetMapping("/dictionary")
    public String dictionary(@RequestParam String word_1, Model model){
        Map<String, String> dictionaryList = new HashMap<String, String>();
        dictionaryList.put("dog", "Chó");
        dictionaryList.put("cat", "Mèo");
        dictionaryList.put("quantity", "Số lượng");
        dictionaryList.put("feature", "Tính năng");

        String word = word_1;
        String result = dictionaryList.get(word);
        model.addAttribute("result", result);
        return "dictionary";
    }
}
