package com.codegym.controller.product;

import com.codegym.exception.NotFoundException;
import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProductController{
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IProductService productService;

    @ModelAttribute("products")
    public Page<Product> products(Pageable pageable){
        return productService.findAll(pageable);
    }

//
//    @ModelAttribute("products2")
//    public Iterable<Product> products(){
//        return productService.findAll();
//    }

    @ModelAttribute("categories")
    private Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/products")
    public ModelAndView showProduct(@PageableDefault(size = 2) Pageable pageable, @RequestParam("search") Optional<String> name){
        ModelAndView modelAndView = new ModelAndView("/product/list");
        if (name.isPresent()){
            Page<Product> products = productService.findAllByName(name.get(), pageable);
            modelAndView.addObject("products", products);
        }else {
            modelAndView.addObject("products", products(pageable));
        }
        return modelAndView;
    }

    @GetMapping("/product/create")
    public ModelAndView showCreateProduct(){
        ModelAndView modelAndView = new ModelAndView("/product/create");
        Iterable<Category> categoryList = categoryService.findAll();
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("categories", categories());
        return modelAndView;
    }

    @PostMapping("/product/create")
    public ModelAndView saveProduct(@Validated  @ModelAttribute("product") Product product, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("/product/create");
        }
        ModelAndView modelAndView = new ModelAndView("/product/create");
        productService.save(product);
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "New product created successful");
        return modelAndView;
    }

    @GetMapping("/product/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) throws NotFoundException {
        Optional<Product> product = productService.findByID(id);
        if (product.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/product/edit");
            modelAndView.addObject("product", product.get());
            modelAndView.addObject("categories", categories());
            return modelAndView;
        } else {
            throw new NotFoundException();
        }
    }

    @PostMapping("/product/edit")
    public ModelAndView updateProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/edit");
        modelAndView.addObject("message", "Product updated successfully");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @GetMapping("/product/view/{id}")
    public ModelAndView viewProduct(@PathVariable Long id) throws NotFoundException {
        Optional<Product> product = productService.findByID(id);
        if (product.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/product/view");
            modelAndView.addObject("product", product.get());
            return modelAndView;
        } else {
            throw new NotFoundException();
        }
    }

    @GetMapping("/product/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable Long id, Pageable pageable) throws NotFoundException {
        Optional<Product> product = productService.findByID(id);
        if (product.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/product/list");
            productService.remove(product.get().getId());
            modelAndView.addObject("products", products(pageable));
//            modelAndView.addObject("products", products());
            modelAndView.addObject("message", "Product deleted successfully");
            return modelAndView;
        } else {
            throw new NotFoundException();
        }
    }

    @ExceptionHandler(NotFoundException.class)
    public String exception(){
        return "/product/error";
    }
}
