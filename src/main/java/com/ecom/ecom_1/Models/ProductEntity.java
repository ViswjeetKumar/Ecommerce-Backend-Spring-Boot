package com.ecom.ecom_1.Models;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releasedDate;
    private Boolean available;

//    public ProductEntity() {}
//
//    public ProductEntity(Integer id, String name, String description, String brand, BigDecimal price, String category, LocalDate releasedDate, Boolean available) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.brand = brand;
//        this.price = price;
//        this.category = category;
//        this.releasedDate = releasedDate;
//        this.available = available;
//    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public void setReleasedDate(LocalDate releasedDate) {
//        this.releasedDate = releasedDate;
//    }
//
//    public Boolean getAvailable() {
//        return available;
//    }
//
//    public void setAvailable(Boolean available) {
//        this.available = available;
//    }

//    public LocalDate getReleasedDate() {
//        return releasedDate;
//    }
}
