package com.codegym.controller;

import com.codegym.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/setting")
public class SettingController {
    Setting setting = new Setting("English", 25, "yes", "");

    @GetMapping()
    public ModelAndView showSetting(){
       ModelAndView modelAndView = new ModelAndView("/setting");
       modelAndView.addObject("settings", setting);
       modelAndView.addObject("language",  new String[] {"English", "Viet Nam", "Japanese", "Chinese"});
       modelAndView.addObject("pageSize", new int[] {5, 10, 15, 25, 50, 100});
       return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute(name = "setting") Setting setting1){
        setting = setting1;
        ModelAndView modelAndView = new ModelAndView("/showSetting");
        modelAndView.addObject("show", setting1);
        modelAndView.addObject("message", "Update success");
        return modelAndView;
    }
}
