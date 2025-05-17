package com.vietduc.hello_spring_boot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_variants")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    private String color;
    private Integer size;

    @OneToMany(mappedBy = "productVariant", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<StoreInventory> inventories;

    public ProductVariant(String color, Integer size) {
        this.color = color;
        this.size = size;
        this.inventories = new ArrayList<>();

    }
}