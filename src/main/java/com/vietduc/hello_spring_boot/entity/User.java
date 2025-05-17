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
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String housingType;

    @ManyToOne // Mot toa nha co the co nhieu nguoi nen su dung chung dia chi
    private Address address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "user-orders")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "user-userVouchers")
    private List<UserVoucher> userVouchers = new ArrayList<>();


    public User(String name, String email, String phone, String housingType) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.housingType = housingType;
        this.orders = new ArrayList<>();
        this.userVouchers = new ArrayList<>();
    }
}