package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    private Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("")
    public ModelAndView showCategory(){
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categories", categories());
        return modelAndView;
    }

    @GetMapping("/category-create")
    public ModelAndView showCreateCategory(){
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("newCategory", new Category());
        return modelAndView;
    }

    @PostMapping("/category-save")
    public ModelAndView saveCategory(@ModelAttribute("newCategory")Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("newCategory", new Category());
        modelAndView.addObject("message", "New Category saved successfully!");
        return modelAndView;
    }

    @GetMapping("/category-edit/{id}")
    public ModelAndView editCategory(@PathVariable Long id){
        Optional<Category> category = categoryService.findAllById(id);
        if (category.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("category", category.get());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/category-update")
    public ModelAndView updateCategory(@ModelAttribute("category") Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Category updated successfully!");
        return modelAndView;
    }

    @GetMapping("/category-delete/{id}")
    public ModelAndView deleteCategory(@PathVariable Long id){
        Optional<Category> category = categoryService.findAllById(id);
        if (category.isPresent()){
            categoryService.delete(category.get().getIdCategory());
            ModelAndView modelAndView = new ModelAndView("/category/list");
            modelAndView.addObject("categories", categories());
            modelAndView.addObject("message", "Category " + category.get().getNameCategory() + " deleted successfully!");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
}
