package cg.wbd.grandemonstration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentController {
    @GetMapping("/")
    public String showCondiment(){
        return "index";
    }

    @PostMapping("/")
    public String save(@RequestParam(value = "condiments", required = false) String[] condiment, Model model){
        if (condiment == null){
            model.addAttribute("message", "You haven't select yet");
            return "index";
        } else {
            model.addAttribute("condiment", condiment);
            return "save";
        }
    }
}
