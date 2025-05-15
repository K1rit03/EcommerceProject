package com.practice.ecommerce.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "User ID cannot be null")
    private Long userId;
    @NotNull(message = "Product ID cannot be null")
    private Long productId;
    @NotNull(message = "Quantity cannot be null")
    private int quantity;
    private double totalPrice;


}
