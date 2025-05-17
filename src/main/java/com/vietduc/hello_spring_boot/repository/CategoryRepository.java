package com.vietduc.hello_spring_boot.repository;

import com.vietduc.hello_spring_boot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
