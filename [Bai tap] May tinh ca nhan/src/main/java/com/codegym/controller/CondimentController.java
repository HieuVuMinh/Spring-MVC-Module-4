package com.codegym.controller;

import com.codegym.model.Method;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CondimentController {
    @GetMapping("/")
    public ModelAndView showCondiment(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("method", Method.method);
        return modelAndView;
    }

    @PostMapping("/")
    public ModelAndView calculate(@RequestParam(name = "number1") String number1,
                                  @RequestParam(name = "number2") String number2,
                                  @RequestParam(name = "method") String method, Model model){
        ModelAndView modelAndView = new ModelAndView("index");
        float num1 = Float.parseFloat(number1);
        float num2 = Float.parseFloat(number2);
        Float result = Method.calculate(num1, num2, method);
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}
