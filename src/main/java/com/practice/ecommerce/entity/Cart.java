package com.practice.ecommerce.entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Long userId;
    private Long productId;
    private int quantity;
    private double totalPrice;


}
