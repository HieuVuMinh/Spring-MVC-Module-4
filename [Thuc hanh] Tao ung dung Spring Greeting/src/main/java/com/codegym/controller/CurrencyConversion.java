package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversion {
    @GetMapping("/currency")
    public String Calculator(@RequestParam(name = "") String rate, Model model) {
        double num1 = Double.parseDouble(rate);
        double res = num1 / 23000;
        model.addAttribute("result", res);
        return "currency";
    }
}
