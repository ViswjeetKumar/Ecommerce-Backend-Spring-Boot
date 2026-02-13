package com.ecom.ecom_1.Controller;
import com.ecom.ecom_1.Product_DTO.ProductDTO;
import com.ecom.ecom_1.Service.ProductService;
import com.ecom.ecom_1.exception.ResourceNotFoundException;
import com.ecom.ecom_1.groupValidation.UpdateProductGroup;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public ResponseEntity<ProductDTO> getProductById(@PathVariable
            @Positive(message = "ID must be positive number") int id) {
            ProductDTO productDTO=service.getProductById(id);
            if(productDTO==null) throw  new ResourceNotFoundException("Product Not Found With ID: "+id);
            return new ResponseEntity<>(productDTO,HttpStatus.OK);
    }

    //Create new Product
    @PostMapping("/create/products")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody  ProductDTO productDTO) {
        ProductDTO createdProduct = service.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    //Update anything in existing Product
    @PatchMapping("/update/products/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@Validated(UpdateProductGroup.class)
                                                        @RequestBody ProductDTO product,
                                                    @Positive(message = "Id must be +ve and integer")
                                                    @PathVariable Integer id) {
        product.setId(id);
        ProductDTO updetedProductDTO = service.updateProduct(product,  id);
        return new ResponseEntity<>(updetedProductDTO, HttpStatus.OK);
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
