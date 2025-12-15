package com.example.Wood.services;

import com.example.Wood.dtos.CartDto;
import com.example.Wood.models.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getCartItemsByUserName(String username);

    double calculateSubtotal(List<Cart> cartItems);

    void addToCart(String username, Long productId);




//--------------------ozumcun
    List<CartDto> getAllCarts();
}
