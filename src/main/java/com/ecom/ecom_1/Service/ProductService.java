package com.ecom.ecom_1.Service;

import com.ecom.ecom_1.Models.ProductEntity;
import com.ecom.ecom_1.Product_DTO.ProductDTO;
import com.ecom.ecom_1.Repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    public  final ModelMapper modelMapper;
    public final  ProductRepository repository;

    public ProductService(ModelMapper modelMapper, ProductRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    public List<ProductDTO> getAllProducts() {
    return repository.findAll().stream()
            .map(emp->modelMapper.map(emp, ProductDTO.class))
            .toList();
    }

    public ProductDTO getProductById(Integer id) {
        ProductEntity foundProduct= repository.findById(id).orElse(null);
        return modelMapper.map(foundProduct, ProductDTO.class);
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        //DTO to Entity Conversion
        ProductEntity newProd=modelMapper.map( productDTO, ProductEntity.class);
        // Business Logic
        if (newProd.getName() != null) {
            // CORRECT: getName() returns String, then call trim() on it
            String trimmedName = newProd.getName().trim();
            newProd.setName(trimmedName);
        }
        //Save product
        ProductEntity saved= repository.save(newProd);
        // Entity to DTO Conversion
        return modelMapper.map(saved, ProductDTO.class);
    }
//Product Exists? Function
    public boolean isExistsById(Integer id){
        return repository.existsById(id);
    }
    public ProductDTO updateProduct(Map<String, Object> product, Integer id ) {
    boolean exists = isExistsById(id);
    if(!exists) return null;
    ProductEntity productFromDB = repository.findById(id).get();
// Using Reflection Concept Here
        product.forEach((field, value)->{
            Field fieldToBeUpdated= ReflectionUtils.findField(ProductEntity.class, field);
           fieldToBeUpdated.setAccessible(true);
           ReflectionUtils.setField(fieldToBeUpdated, productFromDB, value);
        });
        return modelMapper.map(repository.save(productFromDB), ProductDTO.class);
    }

    public Boolean delete_product(Integer id) {
        boolean exist= isExistsById(id);
        if (!exist) return false;
        repository.deleteById(id);
        return true;
    }
}
