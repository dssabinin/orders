package com.example.orders.sale;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "Заказы",  tags={"Заказы"})
@Slf4j
@RestController
@RequestMapping("")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @ApiOperation(value = "Добавление заказа", response = Sale.class)
    @PostMapping("orders")
    public Sale createOrder(@RequestParam String orderName,
                            @RequestParam String clientAddress,
                            @RequestParam Long clientId) {
        return saleService.createOrder(orderName, clientAddress, clientId);
    }

    @ApiOperation(value = "Получение заказа", response = Sale.class)
    @GetMapping("orders/{id}")
    public Sale getOrder(@PathVariable Long id) {
        return saleService.getOrder(id);
    }

    @ApiOperation(value = "Получение списка заказов")
    @GetMapping("orders")
    public Iterable<Sale> getOrders(@RequestParam(required = false) Long clientId) {
        return saleService.getOrders(clientId);
    }

    @ApiOperation(value = "Добавление товара в заказ")
    @PutMapping("orders/{id}/products")
    public Sale putProduct(@PathVariable Long id,
                               @RequestParam Long productId) {
        return saleService.putProduct(id, productId);
    }

    @ApiOperation(value = "Отправляем заказ")
    @PatchMapping("orders/{id}/sended")
    public Sale send(@PathVariable Long id) {
        return saleService.send(id);
    }

    @ApiOperation(value = "Отправка подарка клиенту")
    @PutMapping("orders/gift")
    public Sale putGift(@RequestParam String clientAddress,
                        @RequestParam Long clientId) {
        return saleService.putGift(clientAddress, clientId);
    }

}
