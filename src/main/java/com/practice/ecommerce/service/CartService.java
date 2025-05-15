package com.practice.ecommerce.service;

import com.practice.ecommerce.entity.Cart;
import com.practice.ecommerce.entity.Product;
import com.practice.ecommerce.repository.CartRepository;
import com.practice.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public Cart addItemToCart(Long userId, Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        Cart cart = cartRepository.findByUserIdAndProductId(userId, productId)
                .orElse(new Cart(userId, productId, 0, 0.0));

        cart.setQuantity(cart.getQuantity() + quantity);
        cart.setTotalPrice(cart.getTotalPrice() + product.getPrice() * quantity);

        return cartRepository.save(cart);
    }

    public void removeItemFromCart(Long userId, Long productId) {
        Cart cart = cartRepository.findByUserIdAndProductId(userId, productId)
                .orElseThrow(() -> new RuntimeException("Item not found in cart"));

        cartRepository.delete(cart);
    }

    public Cart updateItemQuantity(Long userId, Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        Cart cart = cartRepository.findByUserIdAndProductId(userId, productId)
                .orElseThrow(() -> new RuntimeException("Item not found in cart"));

        cart.setQuantity(quantity);
        cart.setTotalPrice(product.getPrice() * quantity);

        return cartRepository.save(cart);
    }

    public double calculateTotalPrice(Long userId) {
        List<Cart> cartItems = cartRepository.findByUserId(userId);
        return cartItems.stream()
                .mapToDouble(Cart::getTotalPrice)
                .sum();
    }

    public List<Cart> listCartItems(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public void clearCart(Long userId) {
        List<Cart> cartItems = cartRepository.findByUserId(userId);
        cartRepository.deleteAll(cartItems);
    }
}