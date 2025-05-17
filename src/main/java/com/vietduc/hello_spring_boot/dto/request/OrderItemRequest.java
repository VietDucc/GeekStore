package com.vietduc.hello_spring_boot.dto.request;
import lombok.*;

@Getter
@Setter
public class OrderItemRequest {
    private long productId;
    private String size;
    private String color;
    private Integer quantity;
    private Integer unitPrice;
}
