package com.example.orders.product;

import com.example.orders.sale.Sale;
import com.example.orders.sale.SaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "Товары",  tags={"Товары"})
@Slf4j
@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductsService productsService;

    @ApiOperation(value = "Сохранение товара", response = Sale.class)
    @PostMapping("add")
    public Product createProducts(@RequestParam String name) {
        return productsService.createProduct(name);
    }

    @ApiOperation(value = "Получение товара", response = Product.class)
    @GetMapping("get")
    public Product getProduct(@RequestParam Long id) {
        return productsService.getProduct(id);
    }

    @ApiOperation(value = "Получение списка товаров")
    @GetMapping("get-all")
    public Iterable<Product> getProducts() {
        return productsService.getProducts();
    }


}
