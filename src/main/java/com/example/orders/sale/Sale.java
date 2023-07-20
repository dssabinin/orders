package com.example.orders.sale;

import com.example.orders.client.Client;
import com.example.orders.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Client client;
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL )
    private List<Product> products;
    private Integer sended;

    public Sale(String orderName, Client client) {
        this.name = orderName;
        this.client = client;
    }
}
