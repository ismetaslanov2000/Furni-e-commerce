package com.example.Wood.repositories;

import com.example.Wood.models.Cart;
import com.example.Wood.models.Product;
import com.example.Wood.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findByUserUsername(String username);

    Cart findByUserAndProduct(User user, Product product);

    Cart findByUserUsernameAndProductId(String username, Long productId);
}
