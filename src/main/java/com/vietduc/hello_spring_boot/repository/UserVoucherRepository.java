// UserVoucherRepository.java
package com.vietduc.hello_spring_boot.repository;

import com.vietduc.hello_spring_boot.entity.UserVoucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVoucherRepository extends JpaRepository<UserVoucher, Long> {
    boolean existsByUserIdAndVoucherId(Long userId, Long voucherId);
}
