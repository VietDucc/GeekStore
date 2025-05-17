package com.vietduc.hello_spring_boot.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DiscountPercentRequest {
    private BigDecimal discountPercent;
}
