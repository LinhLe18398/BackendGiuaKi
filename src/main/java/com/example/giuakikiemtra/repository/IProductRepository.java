package com.example.giuakikiemtra.repository;

import com.example.giuakikiemtra.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllByNameContains(String keyword);
}
