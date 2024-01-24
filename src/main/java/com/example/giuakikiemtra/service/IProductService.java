package com.example.giuakikiemtra.service;

import com.example.giuakikiemtra.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Optional<Product> findById(int id);
    void save(Product product);
    void delete(int id);
    void edit(int id, Product product);
}
