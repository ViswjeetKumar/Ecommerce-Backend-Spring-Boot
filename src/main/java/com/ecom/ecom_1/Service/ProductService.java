package com.ecom.ecom_1.Service;

import com.ecom.ecom_1.Models.Product;
import com.ecom.ecom_1.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(int id, Product product) {
        Product updated = repository.findById(id).map(
                existing -> {
                    if (product.getName() != null) {
                        existing.setName(product.getName());
                    }
                    if (product.getDescription() != null) {
                        existing.setDescription(product.getDescription());
                    }
                    if (product.getCatagory() != null) {
                        existing.setCatagory(product.getCatagory());
                    }
                    if (product.getBrand() != null) {
                        existing.setBrand(product.getBrand());
                    }
                    if (product.getPrice() != null) {
                        existing.setPrice(product.getPrice());
                    }
                    if (product.getAvailable() != null) {
                        existing.setAvailable(product.getAvailable());
                    }
                    if (product.getReleased_date() != null) {
                        existing.setReleased_date(product.getReleased_date());
                    }
                    if (product.getQuantity() > 0) {
                        existing.setQuantity(product.getQuantity());
                    }
                    return repository.save(existing);
                }
        ).orElse(null);
        return updated;
    }

    public Boolean delete_product(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
