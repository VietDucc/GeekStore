// VoucherRepository.java
package com.vietduc.hello_spring_boot.repository;

import com.vietduc.hello_spring_boot.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepository extends JpaRepository<Voucher, Long > {
}
