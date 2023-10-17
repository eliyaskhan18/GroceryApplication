package com.groceriesapi.dataAccess.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;
    private String item_code;
    private String item_name;
    private double price;
    private int qty;
    private double total_amount;
}
