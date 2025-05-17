package com.vietduc.hello_spring_boot.dto.request;
import lombok.*;

@Getter
@Setter
public class StoreInventioryRequest {
    private Long idStore;
    private Long idProductVariant;
    private Integer quantity;
}
