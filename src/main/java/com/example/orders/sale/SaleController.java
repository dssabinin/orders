package com.example.orders.sale;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "Заказы",  tags={"Заказы"})
@Slf4j
@RestController
@RequestMapping("orders")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @ApiOperation(value = "Сохранение заказа", response = Sale.class)
    @PostMapping("add")
    public Sale createOrder(@RequestParam String orderName,
                            @RequestParam String clientAdress,
                            @RequestParam Long clientId) {
        return saleService.createOrder(orderName, clientAdress, clientId);
    }
    @ApiOperation(value = "Получение заказа", response = Sale.class)
    @GetMapping("get")
    public Sale getOrder(@RequestParam Long orderId) {
        return saleService.getOrder(orderId);
    }

    @ApiOperation(value = "Получение заказа")
    @GetMapping("get-all")
    public Iterable<Sale> getOrders() {
        return saleService.getAllOrders();
    }

    @ApiOperation(value = "Получение заказов клиента")
    @GetMapping("client-orders")
    public Iterable<Sale> getClientOrders(@RequestParam Long clientId) {
        return saleService.getClientOrders(clientId);
    }

    @ApiOperation(value = "Добавление товара в заказ")
    @PutMapping("add-product")
    public Sale addProduct(@RequestParam Long orderId,
                               @RequestParam Long productId) {
        return saleService.addProduct(orderId, productId);
    }

    @ApiOperation(value = "Отправляем заказ")
    @PutMapping("send")
    public Sale send(@RequestParam Long orderId) {
        return saleService.send(orderId);
    }
}
