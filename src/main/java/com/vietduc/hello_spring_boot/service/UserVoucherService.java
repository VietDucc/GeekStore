package com.vietduc.hello_spring_boot.service;

import com.vietduc.hello_spring_boot.dto.request.UserVoucherRequest;
import com.vietduc.hello_spring_boot.entity.User;
import com.vietduc.hello_spring_boot.entity.UserVoucher;
import com.vietduc.hello_spring_boot.entity.Voucher;
import com.vietduc.hello_spring_boot.repository.UserRepository;
import com.vietduc.hello_spring_boot.repository.UserVoucherRepository;
import com.vietduc.hello_spring_boot.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserVoucherService {

    @Autowired
    private UserVoucherRepository userVoucherRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VoucherRepository voucherRepository;

    public UserVoucher createUserVoucher(UserVoucherRequest request) {
        Long userId = Long.parseLong(request.getIdUser());
        Long voucherId = Long.parseLong(request.getIdVoucher());

        boolean exists = userVoucherRepository.existsByUserIdAndVoucherId(userId, voucherId);
        if (exists) {
            throw new RuntimeException("User already has this voucher");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Voucher voucher = voucherRepository.findById(voucherId)
                .orElseThrow(() -> new RuntimeException("Voucher not found"));

        UserVoucher userVoucher = new UserVoucher();
        userVoucher.setUser(user);
        userVoucher.setVoucher(voucher);
        userVoucher.setUsed(request.getUsed());

        return userVoucherRepository.save(userVoucher);
    }


    public List<UserVoucher> getAllUserVouchers() {
        return userVoucherRepository.findAll();
    }
}
