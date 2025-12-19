package com.example.Wood.services;

import com.example.Wood.dtos.CartDto;

import java.util.List;

public interface CartService {
    List<CartDto> getCartItemsByUserName(String username);

    double calculateSubtotal(List<CartDto> cartItems);

    void addToCart(String username, Long productId);

    void deleteItem(String username, Long productId);

    void increaseQuantity(String username, Long productId);

    void decreaseQuantity(String username, Long productId);


}
