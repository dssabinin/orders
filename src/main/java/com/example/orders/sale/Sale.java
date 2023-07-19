package com.example.orders.sale;

import com.example.orders.client.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    //private Long clientId;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Client client;
}
