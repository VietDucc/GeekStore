package com.vietduc.hello_spring_boot.dto.request;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequest {
    private String name;
    private Integer price;
    private String description;
    private BigDecimal discountPercent;
    private String imageSrc;
}
