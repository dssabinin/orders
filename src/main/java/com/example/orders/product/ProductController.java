package com.example.orders.product;

import com.example.orders.sale.Sale;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "Товары",  tags={"Товары"})
@Slf4j
@RestController
@RequestMapping("")
public class ProductController {

    @Autowired
    private ProductsService productsService;

    @ApiOperation(value = "Сохранение товара", response = Product.class)
    @PostMapping("products")
    public Product createProducts(@RequestParam String name) {
        return productsService.createProduct(name);
    }

    @ApiOperation(value = "Получение товара", response = Product.class)
    @GetMapping("products/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productsService.getProduct(id);
    }

    @ApiOperation(value = "Получение списка товаров")
    @GetMapping("products")
    public Iterable<Product> getProducts() {
        return productsService.getProducts();
    }


}
