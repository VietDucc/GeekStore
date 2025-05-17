package com.vietduc.hello_spring_boot.service;

import com.vietduc.hello_spring_boot.dto.request.VoucherRequest;
import com.vietduc.hello_spring_boot.entity.Voucher;
import com.vietduc.hello_spring_boot.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    public Voucher createVoucher(VoucherRequest request) {
        Voucher voucher = new Voucher();
        voucher.setCode(request.getCode());
        voucher.setDiscountPercent(new java.math.BigDecimal(request.getDiscountPercent()));
        voucher.setMinOrderValue(request.getMinOrderValue());
        voucher.setExpiredAt(request.getExpiredAt());
        voucher.setDescription(request.getDescription());

        return voucherRepository.save(voucher);
    }

    public List<Voucher> getAllVouchers() {
        return voucherRepository.findAll();
    }

    public void deleteVoucher(Long id) {
        if (!voucherRepository.existsById(id)) {
            throw new RuntimeException("Voucher with id " + id + " not found");
        }
        voucherRepository.deleteById(id);
    }
}
