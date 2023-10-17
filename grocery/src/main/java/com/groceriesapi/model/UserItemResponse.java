package com.groceriesapi.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserItemResponse {
    private String item_name;
    private double price;
    private int qty;
}
