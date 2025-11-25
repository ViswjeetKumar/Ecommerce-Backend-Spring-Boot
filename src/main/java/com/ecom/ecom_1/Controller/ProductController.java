package com.ecom.ecom_1.Controller;


import com.ecom.ecom_1.Models.Product;
import com.ecom.ecom_1.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String greet() {
        return "Hello Vam";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get_product_By_id(@PathVariable int id) {
        Product product = service.getProdById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create/products")
    public ResponseEntity<Product> create_product(@RequestBody Product product) {
        Product newProduct = service.createProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PostMapping("/update/products/{id}")
    public ResponseEntity<Product> update_product(@PathVariable int id, @RequestBody Product product) {
        Product updetedProduct = service.updateProduct(id, product);
        if (product != null) {
            return new ResponseEntity<>(updetedProduct, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/delete/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        Boolean deleted_product = service.delete_product(id);
        if (deleted_product) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }


}
