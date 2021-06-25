package com.codegym.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    private boolean checkItem(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()){
            if(entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItem(Product product){
        for (Map.Entry<Product, Integer> entry: products.entrySet()){
            if (entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product){
        if (!checkItem(product)){
            products.put(product, 1);
        }else {
            Map.Entry<Product, Integer> item = selectItem(product);
            Integer newQuantity = item.getValue() +1;
            products.replace(item.getKey(), newQuantity);
        }
    }

    public Integer countProduct(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()){
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return products.size();
    }

    public Float countTotalPrice(){
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()){
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
