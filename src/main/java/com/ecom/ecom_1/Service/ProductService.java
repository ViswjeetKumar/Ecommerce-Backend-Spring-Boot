package com.ecom.ecom_1.Service;

import com.ecom.ecom_1.Models.Product;
import com.ecom.ecom_1.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProdById(int id) {
        return repository.findById(id).orElse(null);
    }
}
