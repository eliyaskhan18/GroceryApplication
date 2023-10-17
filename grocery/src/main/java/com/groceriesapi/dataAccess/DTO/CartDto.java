package com.groceriesapi.dataAccess.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    @JsonProperty("item_code")
    private String item_Code;
    @JsonProperty("name")
    private String item_name;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("qty")
    private int qty;
}
