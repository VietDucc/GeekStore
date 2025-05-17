package com.vietduc.hello_spring_boot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String province;
    private String district;
    private String commune;
    private String detail;

    public Address(String province, String district, String commune, String detail) {
        this.province = province;
        this.district = district;
        this.commune = commune;
        this.detail = detail;
    }
}
