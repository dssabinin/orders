package com.example.orders.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class Rest {

    private RestTemplate restTemplate;
    @Autowired
    Rest(RestTemplateBuilder builder) {
        this.restTemplate = builder
                .build();
    }

    public Client getClient(Long clientId) {
        UriBuilder uriBuilder = UriComponentsBuilder.fromUriString("http://localhost:8090/clients/{id}");
        //uriBuilder.queryParam("clientId",clientId);
        URI uri = uriBuilder.build(clientId);
        System.out.println(uri.toString());
        Client response = this.restTemplate.getForObject(uri, Client.class);
        return response;
    }
}