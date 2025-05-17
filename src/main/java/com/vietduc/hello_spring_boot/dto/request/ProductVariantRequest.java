package com.vietduc.hello_spring_boot.dto.request;
import lombok.*;

@Getter
@Setter
public class ProductVariantRequest {
    private String color;
    private Integer size;
}
