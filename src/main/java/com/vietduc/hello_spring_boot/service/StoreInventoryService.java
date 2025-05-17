package com.vietduc.hello_spring_boot.service;

import com.vietduc.hello_spring_boot.dto.request.StoreInventioryRequest;
import com.vietduc.hello_spring_boot.dto.response.StoreInventoryListWithCountResponse;
import com.vietduc.hello_spring_boot.dto.response.StoreInventoryResponse;
import com.vietduc.hello_spring_boot.entity.ProductVariant;
import com.vietduc.hello_spring_boot.entity.Store;
import com.vietduc.hello_spring_boot.entity.StoreInventory;
import com.vietduc.hello_spring_boot.repository.ProductVariantRepository;
import com.vietduc.hello_spring_boot.repository.StoreInventoryRepository;
import com.vietduc.hello_spring_boot.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreInventoryService {

    @Autowired
    private StoreInventoryRepository storeInventoryRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ProductVariantRepository productVariantRepository;

    public StoreInventory createStoreInventory(StoreInventioryRequest request) {
        Store store = storeRepository.findById(request.getIdStore())
                .orElseThrow(() -> new RuntimeException("Store not found"));

        ProductVariant productVariant = productVariantRepository.findById(request.getIdProductVariant())
                .orElseThrow(() -> new RuntimeException("Product variant not found"));

        StoreInventory inventory = new StoreInventory();
        inventory.setStore(store);
        inventory.setProductVariant(productVariant);
        inventory.setQuantity(request.getQuantity());

        return storeInventoryRepository.save(inventory);
    }

    public List<StoreInventoryResponse> getAllInventories() {
        List<StoreInventory> inventories = storeInventoryRepository.findAll();

        return inventories.stream().map(inv -> new StoreInventoryResponse(
                inv.getId(),
                inv.getQuantity(),
                new StoreInventoryResponse.StoreInfo(
                        inv.getStore().getId(),
                        inv.getStore().getName(),
                        inv.getStore().getLocation()
                ),
                new StoreInventoryResponse.ProductVariantInfo(
                        inv.getProductVariant().getId(),
                        inv.getProductVariant().getColor(),
                        inv.getProductVariant().getSize()
                )
        )).toList();
    }

    public StoreInventoryListWithCountResponse getInventoriesByProductVariantId(Long productVariantId) {
        List<StoreInventory> allInventories = storeInventoryRepository.findByProductVariantId(productVariantId);

        // Lọc ra những inventory có quantity > 0
        List<StoreInventory> filteredInventories = allInventories.stream()
                .filter(inv -> inv.getQuantity() != null && inv.getQuantity() > 0)
                .toList();

        List<StoreInventoryResponse> responses = filteredInventories.stream().map(inv -> new StoreInventoryResponse(
                inv.getId(),
                inv.getQuantity(),
                new StoreInventoryResponse.StoreInfo(
                        inv.getStore().getId(),
                        inv.getStore().getName(),
                        inv.getStore().getLocation()
                ),
                new StoreInventoryResponse.ProductVariantInfo(
                        inv.getProductVariant().getId(),
                        inv.getProductVariant().getColor(),
                        inv.getProductVariant().getSize()
                )
        )).toList();

        // Đếm số lượng cửa hàng distinct với quantity > 0
        int storeCount = (int) filteredInventories.stream()
                .map(inv -> inv.getStore().getId())
                .distinct()
                .count();

        return new StoreInventoryListWithCountResponse(storeCount, responses);
    }



}
