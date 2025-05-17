package com.vietduc.hello_spring_boot.dto.request;

import lombok.*;

@Getter
@Setter
public class AddressRequest {
    private String province;
    private String district;
    private String commune;
    private String detail;
}
