package com.vietduc.hello_spring_boot.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "store_inventory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name= "store_id")
    @JsonBackReference
    private Store store;

    @ManyToOne
    @JoinColumn(name = "product_variant_id")
    @JsonBackReference
    private ProductVariant productVariant;

    private Integer quantity;
}
