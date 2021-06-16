package com.codegym.repository;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository implements IProductRepository{
    private static Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "Phone", 1000, "iPhone", "apple"));
        products.put(2, new Product(2, "TV", 2000, "TV", "Panasonic"));
        products.put(3, new Product(3, "Car", 11000, "Car", "Kia"));
        products.put(4, new Product(4, "Fan", 4000, "Fan", "Kangaroo"));
    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int key) {
        return products.get(key);
    }

    @Override
    public Product findByName(String name) {
        return products.get("name");
    }

    @Override
    public Product addProduct(Product product) {
        return product;
    }

    @Override
    public Product updateProduct(int key, Product product) {
        products.replace(key, product);
        return product;
    }

    @Override
    public void deleteProduct(int key) {
        products.remove(key);
    }
}
