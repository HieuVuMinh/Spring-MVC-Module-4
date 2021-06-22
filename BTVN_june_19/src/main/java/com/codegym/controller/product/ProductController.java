package com.codegym.controller.product;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.repository.product.IProductRepository;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController{
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IProductService productService;

    @GetMapping("/product")
    public ModelAndView showProduct(){
        ModelAndView modelAndView = new ModelAndView("/list");
        List<Product> product = productService.findAll();
        modelAndView.addObject("products", product);
        return modelAndView;
    }

    @GetMapping("/product/create")
    public ModelAndView showCreateProduct(){
        ModelAndView modelAndView = new ModelAndView("/create");
        List<Category> categoryList = categoryService.findAll();
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("categories", categoryList);
        return modelAndView;
    }

    @PostMapping("/product/create")
    public ModelAndView createProduct(@ModelAttribute("product") Product product){
        ModelAndView modelAndView = new ModelAndView("/create");
        productService.save(product);
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "New product created successful");
        return modelAndView;
    }
}
