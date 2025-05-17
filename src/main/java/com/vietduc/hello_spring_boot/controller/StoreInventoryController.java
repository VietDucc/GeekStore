package com.vietduc.hello_spring_boot.controller;

import com.vietduc.hello_spring_boot.dto.request.StoreInventioryRequest;
import com.vietduc.hello_spring_boot.dto.response.StoreInventoryListWithCountResponse;
import com.vietduc.hello_spring_boot.dto.response.StoreInventoryResponse;
import com.vietduc.hello_spring_boot.entity.StoreInventory;
import com.vietduc.hello_spring_boot.service.StoreInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/store-inventories")
public class StoreInventoryController {

    @Autowired
    private StoreInventoryService storeInventoryService;

    @PostMapping
    public StoreInventory createStoreInventory(@RequestBody StoreInventioryRequest request) {
        return storeInventoryService.createStoreInventory(request);
    }

    @GetMapping
    public List<StoreInventoryResponse> getAllStoreInventories() {
        return storeInventoryService.getAllInventories();
    }
//    Lay danh sach san pham con trong kho theo ProductVariantId
    @GetMapping("/productVariant/{productVariantId}")
    public StoreInventoryListWithCountResponse getByProductVariantId(@PathVariable Long productVariantId) {
        return storeInventoryService.getInventoriesByProductVariantId(productVariantId);
}
}
