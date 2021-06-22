package com.codegym.controller;

import com.codegym.model.BlogWeb;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ModelAndView showBlogForm(){
        ModelAndView modelAndView = new ModelAndView("/list");
        List<BlogWeb> blogWebs = blogService.findAll();
        modelAndView.addObject("newBlog", blogWebs);
        modelAndView.addObject("blogs", new BlogWeb());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createBlog(@ModelAttribute("blogs") BlogWeb blogWeb){
        ModelAndView modelAndView = new ModelAndView("/list");
        blogService.save(blogWeb);
        List<BlogWeb> blogWeb1 = blogService.findAll();
        modelAndView.addObject("newBlog", blogWeb1);
        modelAndView.addObject("blogs", new BlogWeb());
        modelAndView.addObject("message", "New Blog created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditBlog(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        BlogWeb blogWeb = blogService.findById(id);
        if (blogWeb != null){
            modelAndView.addObject("blogs", blogWeb);
            return modelAndView;
        }
        else {
            modelAndView.addObject("message", "not found");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView editBlog(@ModelAttribute("blogs") BlogWeb blogWeb){
        ModelAndView modelAndView = new ModelAndView("/edit");
        blogService.save(blogWeb);
        modelAndView.addObject("blogs", blogWeb);
        modelAndView.addObject("message", "Blog edited successfully");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewBLog(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/view");
        BlogWeb blogWeb = blogService.findById(id);
        if(blogWeb != null){
            modelAndView.addObject("blogs", blogWeb);
            return modelAndView;
        } else {
            modelAndView.addObject("message", "Not found ");
            return modelAndView;
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        BlogWeb blogWeb = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/list");
        if (blogWeb != null){
            blogService.remove(blogWeb.getId());
            modelAndView.addObject("message", "Blog " + blogWeb.getName() + " deleted successfully");
            return modelAndView;
        } else {
            modelAndView.addObject("err", "Error to delete this blog" );
            return modelAndView;
        }
    }
}
