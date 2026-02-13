package com.ecom.ecom_1.Product_DTO;

import com.ecom.ecom_1.groupValidation.CreateProductGroup;
import com.ecom.ecom_1.groupValidation.UpdateProductGroup;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @Null(groups = CreateProductGroup.class, message = "Id must be null while creating")
    private Integer id;

    @NotBlank(message = "Name is required field", groups = CreateProductGroup.class )
    @Size(min = 2, max = 50, message = "product name must be between 2 and 50 characters", groups = {CreateProductGroup.class, UpdateProductGroup.class})
    private String name;

    @NotBlank(message = "Description is required field", groups = CreateProductGroup.class)
    @Size(min = 5, max = 500, message = "description must be between 5 and 500 characters", groups = {CreateProductGroup.class, UpdateProductGroup.class})
    private String description;

    @NotBlank(message = "Brand is required", groups = CreateProductGroup.class)
    @Size(min = 2, max = 50, message = "Brand must be between 2 and 50 characters", groups = {CreateProductGroup.class, UpdateProductGroup.class})
    private String brand;

    @NotNull(message = "Price is required", groups = CreateProductGroup.class)
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Price can have up to 2 decimal places", groups = {CreateProductGroup.class, UpdateProductGroup.class})
    private BigDecimal price;

    @NotBlank(message = "Category is required", groups = CreateProductGroup.class)
    @Size(min = 2, max = 50, message = "Category must be between 2 and 50 characters", groups = {CreateProductGroup.class, UpdateProductGroup.class})
    private String category;

    @NotNull(message = "Release date is required", groups = CreateProductGroup.class)
    @PastOrPresent(message = "Release date cannot be in the future", groups = {CreateProductGroup.class})
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releasedDate;

    @NotNull(message = "Availability status is required", groups = {CreateProductGroup.class})
    private Boolean available;
}
