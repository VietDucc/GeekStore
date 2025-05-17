package com.vietduc.hello_spring_boot.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class OrderRequest {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPhone;
    private AddressRequest address;
    private List<OrderItemRequest> items;
    private Integer totalPrice;

}
