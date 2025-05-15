package com.practice.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Adicionado como chave primária

    @NotNull(message = "Product name cannot be null")
    private String name;

    private String description;

    @Min(value = 0, message = "Price must be greater than or equal to 0")
    @NotNull(message = "Price cannot be null")
    private double price;

    @NotNull(message = "Stock quantity cannot be null")
    private int stockQuantity;

    private String category;

    private String imageUrl;
}