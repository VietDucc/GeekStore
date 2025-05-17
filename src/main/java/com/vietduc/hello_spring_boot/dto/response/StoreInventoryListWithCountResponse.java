package com.vietduc.hello_spring_boot.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class StoreInventoryListWithCountResponse {
    private int storeCount;
    private List<StoreInventoryResponse> inventories;
}
