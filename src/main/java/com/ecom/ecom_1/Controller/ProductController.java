package com.ecom.ecom_1.Controller;


import com.ecom.ecom_1.Models.Product;
import com.ecom.ecom_1.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
        if(product != null){
                    return new ResponseEntity<>(product, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create/products")
    public ResponseEntity<Product> create_product(@PathVariable Product product){
        .........
    }


}
