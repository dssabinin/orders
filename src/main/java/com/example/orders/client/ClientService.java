package com.example.orders.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private Rest rest;

    public Client saveClient(Long clientId, String address) {
        Optional<Client> clientOptional = clientRepo.findById(clientId);
        Client clientRest = rest.getClient(clientId);
        Client client = clientOptional.orElse(clientRest);
        client.setDeliveryAddress(address);
        client.setName(clientRest.getName());
        return clientRepo.save(client);
    }

}
