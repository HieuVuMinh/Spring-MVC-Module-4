package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    private Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @ModelAttribute("products")
    private Iterable<Product> products(){
        return productService.findAll();
    }

    @GetMapping("")
    public ModelAndView showProduct(){
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", products());
        return modelAndView;
    }

    @GetMapping("/product-create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("categories", categories());
        modelAndView.addObject("newProduct", new Product());
        return modelAndView;
    }

    @PostMapping("/product-create")
    public ModelAndView createProduct(@ModelAttribute("newProduct") Product product){
        ModelAndView modelAndView = new ModelAndView("/product/create");
        productService.save(product);
        modelAndView.addObject("newProduct", new Product());
        modelAndView.addObject("message", "Product created successfully!");
        return modelAndView;
    }

    @GetMapping("/product-edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<Product> products = productService.findAllById(id);
        if(products.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/product/edit");
            modelAndView.addObject("product", products.get());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/product-edit")
    public ModelAndView updateProduct(@ModelAttribute("product")Product product){
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        modelAndView.addObject("product", product);
        modelAndView.addObject("message", "Product updated successfully!");
        return modelAndView;
    }

    @GetMapping("/product-view/{id}")
    public ModelAndView viewProduct(@PathVariable Long id){
        Optional<Product> product = productService.findAllById(id);
        if (product.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/product/view");
            modelAndView.addObject("product", product.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @GetMapping("/product-delete/{id}")
    public ModelAndView deleteProduct(@PathVariable Long id){
        Optional<Product> product = productService.findAllById(id);
        if (product.isPresent()){
            productService.delete(id);
            ModelAndView modelAndView = new ModelAndView("/product/list");
            modelAndView.addObject("products", products());
            modelAndView.addObject("message", "Product " + product.get().getNameProduct() + " deleted successfully!");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
}
