package com.vietduc.hello_spring_boot.controller;

import com.vietduc.hello_spring_boot.dto.request.VoucherRequest;
import com.vietduc.hello_spring_boot.entity.Voucher;
import com.vietduc.hello_spring_boot.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vouchers")
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    @PostMapping
    public Voucher createVoucher(@RequestBody VoucherRequest request) {
        return voucherService.createVoucher(request);
    }

    @GetMapping
    public List<Voucher> getAllVouchers() {
        return voucherService.getAllVouchers();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVoucher(@PathVariable Long id) {
        voucherService.deleteVoucher(id);
        return ResponseEntity.ok("Voucher deleted successfully");
    }

}
