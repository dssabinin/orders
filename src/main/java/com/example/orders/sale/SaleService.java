package com.example.orders.sale;

import com.example.orders.client.Client;
import com.example.orders.client.ClientService;
import com.example.orders.product.Product;
import com.example.orders.product.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepo saleRepo;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProductRepo productRepo;

    public Sale createOrder(String orderName, String clientAddress, Long clientId) {
        Client client = clientService.saveClient(clientId, clientAddress);
        return saleRepo.save(new Sale(orderName, client));
    }

    public Sale getOrder(Long orderId) {
        return saleRepo.findById(orderId).orElseThrow();
    }

    public Iterable<Sale> getAllOrders() {
        return saleRepo.findAll();
    }

    public Iterable<Sale> getClientOrders(Long clientId) {
        return saleRepo.findAllByClient(clientService.getClient(clientId));
    }

    public Sale putProduct(Long orderId, Long productId) {
        Sale sale = saleRepo.findById(orderId).orElseThrow();
        Product product = productRepo.findById(productId).orElseThrow();
        List<Product> products = sale.getProducts();
        if (products==null) {
            products=new ArrayList<>();
            sale.setProducts(products);
        }
        if (!products.contains(product)) {
            products.add(product);
        }
        return saleRepo.save(sale);
    }

    public Sale send(Long orderId) {
        Sale sale = saleRepo.findById(orderId).orElseThrow();
        sale.setSended(1);
        return saleRepo.save(sale);
    }

    public Iterable<Sale> getOrders(Long clientId) {
        if (clientId==null) {
            return getAllOrders();
        } else {
            return getClientOrders(clientId);
        }
    }

    public Sale putGift(String clientAddress, Long clientId) {
        Client client = clientService.saveClient(clientId, clientAddress);
        Sale sale = putGift(client);
        return send(sale.getId());
    }

    /**делаем подарок*/
    private Sale putGift(Client client) {
        Optional<Sale> saleOptional = saleRepo.findByClientAndName(client, "gift");
        if (saleOptional.isPresent()) {
            return saleOptional.get();
        }
        Sale sale = new Sale("gift", client);
        List<Product> products = new ArrayList<>();
        products.add(productRepo.findByName("gift").orElseThrow());
        sale.setProducts(products);
        return saleRepo.save(sale);
    }


}
