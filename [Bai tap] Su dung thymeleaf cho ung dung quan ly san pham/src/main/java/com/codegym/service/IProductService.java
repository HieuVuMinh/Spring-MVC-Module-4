package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(int id);

    Product findByName(String name);

    Product addProduct(Product product);

    Product updateProduct(int id, Product product);

    void deleteProduct(int id);
}
