package com.example.orders.sale;

import com.example.orders.client.Client;
import com.example.orders.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    private SaleRepo saleRepo;
    @Autowired
    private ClientService clientService;

    public Sale createOrder(String orderName, String clientAddress, Long clientId) {
        Client client = clientService.saveClient(clientId, clientAddress);
        return saleRepo.save(new Sale(null, orderName, client));
    }

    public Sale getOrder(Long orderId) {
        return saleRepo.findById(orderId).orElseThrow();
    }

    public Iterable<Sale> getAllOrders() {
        return saleRepo.findAll();
    }
}
