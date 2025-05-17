package com.vietduc.hello_spring_boot.controller;

import com.vietduc.hello_spring_boot.dto.request.UserVoucherRequest;
import com.vietduc.hello_spring_boot.entity.UserVoucher;
import com.vietduc.hello_spring_boot.service.UserVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-vouchers")
public class UserVoucherController {

    @Autowired
    private UserVoucherService userVoucherService;

    @PostMapping
    public UserVoucher createUserVoucher(@RequestBody UserVoucherRequest request) {
        return userVoucherService.createUserVoucher(request);
    }

    @GetMapping
    public List<UserVoucher> getAllUserVouchers() {
        return userVoucherService.getAllUserVouchers();
    }
}
