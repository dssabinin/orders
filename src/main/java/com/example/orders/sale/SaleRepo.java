package com.example.orders.sale;

import com.example.orders.client.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SaleRepo extends CrudRepository<Sale, Long> {

    Iterable<Sale> findAllByClient(Client client);
    Optional<Sale> findByClientAndName(Client client, String orderName);
}
