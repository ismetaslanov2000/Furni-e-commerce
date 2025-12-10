package com.example.Wood.repositories;

import com.example.Wood.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepostitory extends JpaRepository<Product,Long> {
}
