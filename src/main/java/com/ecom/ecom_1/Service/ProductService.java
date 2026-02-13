package com.ecom.ecom_1.Service;

import com.ecom.ecom_1.Models.ProductEntity;
import com.ecom.ecom_1.Product_DTO.ProductDTO;
import com.ecom.ecom_1.Repository.ProductRepository;
import com.ecom.ecom_1.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public  final ModelMapper modelMapper;
    public final  ProductRepository repository;
    private ProductEntity productFromDB;

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
//        ProductEntity foundProduct= repository.findById(id).orElse(null);
//        return modelMapper.map(foundProduct, ProductDTO.class);
        return repository.findById(id).map(
                entry-> modelMapper.map(entry, ProductDTO.class)
        ).orElseThrow(()-> new ResourceNotFoundException("Product not found with id: "+id));
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
        boolean isExist= repository.existsById(id);
        if(!isExist) throw  new ResourceNotFoundException("Product not found with ID: "+id);
        return true;
    }
    public ProductDTO updateProduct(ProductDTO product, Integer id ) {
    isExistsById(id);
    ProductEntity productFromDB = repository.findById(id).get();
    modelMapper.getConfiguration().setSkipNullEnabled(true);
    modelMapper.map(product, productFromDB);
    return modelMapper.map(repository.save(productFromDB), ProductDTO.class);
// Using Reflection Concept Here
//        product.forEach((field, value)->{
//            Field fieldToBeUpdated= ReflectionUtils.findField(ProductEntity.class, field);
//           fieldToBeUpdated.setAccessible(true);
//           ReflectionUtils.setField(fieldToBeUpdated, productFromDB, value);
//        });
//        return modelMapper.map(repository.save(productFromDB), ProductDTO.class);
    }

    public Boolean delete_product(Integer id) {
        isExistsById(id);
        repository.deleteById(id);
        return true;
    }
}
