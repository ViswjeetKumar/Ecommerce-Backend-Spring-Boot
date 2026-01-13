package com.ecom.ecom_1.Controller;
import com.ecom.ecom_1.Product_DTO.ProductDTO;
import com.ecom.ecom_1.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RestController
public class ProductController {
    final ProductService service;
    public ProductController(ProductService service) {
        this.service = service;
    }
    @GetMapping("/")
    public String greet() {
        return "Welcome Sir/Ma'am, " +
                "  This Is Home Page.";
    }

    //Get All Products
    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProduct() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    //Get Product By ID
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable int id) {
        return new ResponseEntity<>(service.getProductById(id), HttpStatus.OK);
    }

    //Create new Product
    @PostMapping("/create/products")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody  ProductDTO productDTO) {
        ProductDTO createdProduct = service.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    //Update anything in existing Product
    @PatchMapping("/update/products/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody Map<String, Object> product, @PathVariable Integer id) {
        ProductDTO updetedProductDTO = service.updateProduct(product,  id);
        if (updetedProductDTO != null) {
            return new ResponseEntity<>(updetedProductDTO, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    //Delete or Remove any product
    @DeleteMapping("/delete/products/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable int id) {
        Boolean deleted_product = service.delete_product(id);
        if (deleted_product) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}
