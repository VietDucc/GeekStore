package com.vietduc.hello_spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer price;
    private String description;
    private String imageSrc;

    //Dùng BigDecimal cho phần trăm
    private BigDecimal discountPercent;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<ProductVariant> productVariants = new ArrayList<>();

    public Product(String name, Integer price, String description, BigDecimal discountPercent, String imageSrc) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.discountPercent = discountPercent;
        this.imageSrc = imageSrc;
        this.productVariants = new ArrayList<>();
    }
}
