// OrderItemRepository.java
package com.vietduc.hello_spring_boot.repository;

import com.vietduc.hello_spring_boot.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
