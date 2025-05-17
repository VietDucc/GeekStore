package com.vietduc.hello_spring_boot.controller;

import com.vietduc.hello_spring_boot.dto.request.StoreRequest;
import com.vietduc.hello_spring_boot.entity.Store;
import com.vietduc.hello_spring_boot.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    // Tạo cửa hàng mới
    @PostMapping
    public Store createStore(@RequestBody StoreRequest request) {
        return storeService.createStore(request);
    }

    // Lấy danh sách cửa hàng
    @GetMapping
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    // Lấy cửa hàng theo id
    @GetMapping("/{id}")
    public Store getStoreById(@PathVariable Long id) {
        return storeService.getStoreById(id);
    }

    // Cập nhật cửa hàng
    @PutMapping("/{id}")
    public Store updateStore(@PathVariable Long id, @RequestBody StoreRequest request) {
        return storeService.updateStore(id, request);
    }

    // Xóa cửa hàng
    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
    }
}
