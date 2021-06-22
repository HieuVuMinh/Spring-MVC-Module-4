package com.codegym.controller;

import com.codegym.model.Comment;
import com.codegym.service.HibernateCommentService;
import com.codegym.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/picture")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping("")
    public ModelAndView picture(){
        ModelAndView modelAndView = new ModelAndView("picture");
        modelAndView.addObject("picture", commentService.findAll());
        return modelAndView;
    }

    @GetMapping("/show")
    public ModelAndView showPicture(){
        ModelAndView modelAndView = new ModelAndView("/viewPicture");
        modelAndView.addObject("rate", new int[] {1, 2, 3, 4, 5});
        modelAndView.addObject("comment", new Comment());
        return modelAndView;
    }

    @PostMapping("/comment")
    public ModelAndView picture(@ModelAttribute("comment") Comment comment){
        ModelAndView modelAndView = new ModelAndView("/viewPicture");
        commentService.save(comment);
        modelAndView.addObject("rate", new int[] {1, 2, 3, 4, 5});
        modelAndView.addObject("commentPicture", commentService.findAll());
        modelAndView.addObject("comment", new Comment());
        return modelAndView;
    }
}
