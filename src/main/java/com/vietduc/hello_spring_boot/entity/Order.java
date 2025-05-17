package com.vietduc.hello_spring_boot.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value ="user-order")
    private User user;
    private String userName;
    private String userEmail;
    private String userPhone;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private Integer totalPrice;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<OrderItem> items = new ArrayList<>();

    public Order(User user, Address address, Integer totalPrice, LocalDateTime createdAt) {
        this.user = user;
        this.userName = user.getName();
        this.userEmail = user.getEmail();
        this.userPhone = user.getPhone();
        this.address = address;
        this.totalPrice = totalPrice;
        this.createdAt = LocalDateTime.now();
        this.items = new ArrayList<>();
    }
}
