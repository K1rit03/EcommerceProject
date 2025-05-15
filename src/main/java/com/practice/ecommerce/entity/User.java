package com.practice.ecommerce.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;


@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @NotNull(message = "Username cannot be null")
    private String username;

    @Size(min = 8, message = "Password must be at least 8 characters")
    @NotNull(message = "Password cannot be null")
    private String password;

    @Email(message = "Email should be valid")
    @NotNull(message = "Email cannot be null")
    private String email;

    private String address;

    @Pattern(regexp = "\\d{10,15}", message = "Phone number must be between 10 and 15 digits")
    private String phoneNumber;

}
