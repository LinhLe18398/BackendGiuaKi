package com.example.giuakikiemtra.service;

import com.example.giuakikiemtra.model.Product;
import com.example.giuakikiemtra.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductService implements IProductService {
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void delete(int id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public void edit(int id, Product product) {
        iProductRepository.save(new Product(id, product.getName(), product.getDetail(), product.getPrice(), product.getDay()));
    }
}
