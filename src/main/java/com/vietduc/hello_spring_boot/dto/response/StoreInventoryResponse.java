package com.vietduc.hello_spring_boot.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StoreInventoryResponse {
    private Long id;
    private Integer quantity;
    private StoreInfo store;
    private ProductVariantInfo productVariant;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class StoreInfo {
        private Long id;
        private String name;
        private String location;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ProductVariantInfo {
        private Long id;
        private String color;
        private Integer size;
    }
}
