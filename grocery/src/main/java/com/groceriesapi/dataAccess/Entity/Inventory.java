package com.groceriesapi.dataAccess.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Inventory {
    @Id
    private String item_code;
    private String item_name;
    private int total_qty;
    private int ordered_qty;
    private int balance_qty;

}
