package com.example.orders.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {

    @Autowired
    private ProductRepo productRepo;


    public Product createProduct(String name) {
        return productRepo.save(new Product(name));
    }

    public Product getProduct(Long id) {
        return productRepo.findById(id).orElseThrow();
    }

    public Iterable<Product> getProducts() {
        return productRepo.findAll();
    }
}
