// AddressRepository.java
package com.vietduc.hello_spring_boot.repository;

import com.vietduc.hello_spring_boot.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByProvinceAndDistrictAndCommuneAndDetail(String province, String district, String commune, String detail);

}
