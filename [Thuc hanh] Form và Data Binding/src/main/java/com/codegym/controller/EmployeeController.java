package com.codegym.controller;

import com.codegym.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @RequestMapping(value = "/showroom", method = RequestMethod.GET)
    public String showRoom(Model model){
        model.addAttribute("employee", new Employee());
        return "/employee/create";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String submit(@ModelAttribute("employee") Employee employee, Model model){
        model.addAttribute("employee", employee);
        return "/employee/info";
    }

}
