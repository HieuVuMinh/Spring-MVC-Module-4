package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    Product findById(int id);

    Product findByName(String name);

    Product addProduct(Product product);

    Product updateProduct(int id, Product product);

    void deleteProduct(int id);
}
