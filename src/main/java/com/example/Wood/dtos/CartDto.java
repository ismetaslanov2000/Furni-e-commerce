package com.example.Wood.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private Long id;
    private String name;
    private String imageUrl;
    private int quantity;
    private Double price;
    public double getTotal() {
        return quantity * price;
    }
}
