package com.groceriesapi.dataAccess.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cart")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private long cartId;
    @Column(name = "item_code")
    private String item_code;
    @Column(name = "Item_name")
    private String item_name;
    @Column(name = "Quantity")
    private int qty;
    @Column(name = "price")
    private double price;
    @Column(name = "Amount")
    private double amount;

}
