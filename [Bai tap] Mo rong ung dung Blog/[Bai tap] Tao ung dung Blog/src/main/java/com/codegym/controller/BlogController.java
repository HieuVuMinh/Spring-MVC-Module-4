package com.codegym.controller;

import com.codegym.model.BlogWeb;
import com.codegym.model.Category;
import com.codegym.service.blog.IBlogService;
import com.codegym.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    private Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @ModelAttribute("newBLog")
    public Iterable<BlogWeb> listBlog(){
        return blogService.findAll();
    }

    @GetMapping("")
    public ModelAndView showBlogForm(){
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("categories", categories());
        modelAndView.addObject("newBlog", listBlog());
        modelAndView.addObject("blogs", new BlogWeb());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createBlog(@ModelAttribute("blogs") BlogWeb blogWeb){
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        blogService.save(blogWeb);
        modelAndView.addObject("blogs", new BlogWeb());
        modelAndView.addObject("newBlog", listBlog());
        modelAndView.addObject("message", "New Blog created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditBlog(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        Optional<BlogWeb> blogWeb = blogService.findById(id);
        if (blogWeb.isPresent()){
            modelAndView.addObject("categories", categories());
            modelAndView.addObject("blogs", blogWeb.get());
            return modelAndView;
        }
        else {
            modelAndView.addObject("message", "not found");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView editBlog(@ModelAttribute("blogs") BlogWeb blogWeb){
        blogService.save(blogWeb);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blogs", blogWeb);
        modelAndView.addObject("message", "Blog edited successfully");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewBLog(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/blog/view");
        Optional<BlogWeb> blogWeb = blogService.findById(id);
        if(blogWeb.isPresent()){
            modelAndView.addObject("blogs", blogWeb.get());
            return modelAndView;
        } else {
            modelAndView.addObject("message", "Not found ");
            return modelAndView;
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        Optional<BlogWeb> blogWeb = blogService.findById(id);
        if (blogWeb.isPresent()){
            blogService.remove(blogWeb.get().getId());
            ModelAndView modelAndView = new ModelAndView("/blog/list");
            modelAndView.addObject("blogs", new BlogWeb());
            modelAndView.addObject("newBlog", listBlog());
            modelAndView.addObject("message", "Blog " + blogWeb.get().getName() + " deleted successfully");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
}
