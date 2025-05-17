package com.vietduc.hello_spring_boot.dto.request;

import lombok.*;


@Getter
@Setter
public class UserRequest {
    private String name;
    private String email;
    private String phone;
    private String housingType;
    private AddressRequest address;
}
