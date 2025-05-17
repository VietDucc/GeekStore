// StoreInventoryRepository.java
package com.vietduc.hello_spring_boot.repository;

import com.vietduc.hello_spring_boot.entity.StoreInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreInventoryRepository extends JpaRepository<StoreInventory, Long> {
    List<StoreInventory> findByProductVariantId(Long productVariantId);
}
