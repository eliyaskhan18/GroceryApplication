package com.groceriesapi.dataAccess.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
    @Id
    @Column(name = "item_code")
    private String item_code;
    @Column(name = "Name")
    private String name;
    @Column(name = "Price")
    private Double price;
    @Column(name = "Description")
    private String description;

}
