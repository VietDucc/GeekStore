package com.vietduc.hello_spring_boot.service;

import com.vietduc.hello_spring_boot.dto.request.AddressRequest;
import com.vietduc.hello_spring_boot.entity.Address;
import com.vietduc.hello_spring_boot.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address saveOrGetAddress(AddressRequest req) {
        String province = req.getProvince().trim();
        String district = req.getDistrict().trim();
        String commune = req.getCommune().trim();
        String detail = req.getDetail().trim();

        return addressRepository
                .findByProvinceAndDistrictAndCommuneAndDetail(
                        province, district, commune, detail
                )
                .orElseGet(() -> {
                    Address newAddress = new Address();
                    newAddress.setProvince(province);
                    newAddress.setDistrict(district);
                    newAddress.setCommune(commune);
                    newAddress.setDetail(detail);
                    return addressRepository.save(newAddress);
                });
    }
}
