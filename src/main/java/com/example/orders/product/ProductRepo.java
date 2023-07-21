package com.example.orders.product;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepo extends CrudRepository<Product, Long> {
    Optional<Product> findByName(String name);
}
