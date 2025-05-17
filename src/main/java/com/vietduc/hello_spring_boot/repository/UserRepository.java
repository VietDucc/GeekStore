// UserRepository.java
package com.vietduc.hello_spring_boot.repository;

import com.vietduc.hello_spring_boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
