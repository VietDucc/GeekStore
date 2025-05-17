package com.vietduc.hello_spring_boot.dto.request;
import lombok.*;

@Getter
@Setter
public class UserVoucherRequest {
    private Boolean used;
    private String idVoucher;
    private String idUser;
}
