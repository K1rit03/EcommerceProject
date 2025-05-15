package com.practice.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User cannot be null")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    @NotNull(message = "Product cannot be null")
    private Product product;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    @NotNull(message = "Total price cannot be null")
    private double totalPrice;

    @NotNull(message = "Order date cannot be null")
    private LocalDate orderDate;

    @NotNull(message = "Status cannot be null")
    private String status; // Status do pedido (ex.: "PENDING", "COMPLETED")
}