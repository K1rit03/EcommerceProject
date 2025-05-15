package com.practice.ecommerce.controller;


import com.practice.ecommerce.entity.Cart;
import com.practice.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public void addToCart(Long userId, Long productId, int quantity){
        cartService.addItemToCart(userId, productId, quantity);
    }

    @PutMapping("/update/{productId}")
    public void updateCart(Long userId, Long productId, int quantity){
        cartService.updateItemQuantity(userId, productId, quantity);
    }

    @DeleteMapping("/remove/{productId}")
    public void removeFromCart(Long userId, Long productId){
        cartService.removeItemFromCart(userId, productId);
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getCartItems(@RequestParam Long userId) {
        List<Cart> cartItems = cartService.listCartItems(userId);
        return ResponseEntity.ok(cartItems);
    }

    @DeleteMapping("/clear")
    public void clearCart(Long userId){
        cartService.clearCart(userId);
    }

    @GetMapping("/total")
    public ResponseEntity<Double> getTotalPrice(@RequestParam Long userId) {
        double totalPrice = cartService.calculateTotalPrice(userId);
        return ResponseEntity.ok(totalPrice);
    }


}
