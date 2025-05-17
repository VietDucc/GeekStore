package com.vietduc.hello_spring_boot.service;

import com.vietduc.hello_spring_boot.dto.request.StoreRequest;
import com.vietduc.hello_spring_boot.entity.Store;
import com.vietduc.hello_spring_boot.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    // Tạo cửa hàng mới
    public Store createStore(StoreRequest request) {
        Store store = new Store();
        store.setName(request.getName());
        store.setLocation(request.getLocation());
        store.setDescription(request.getDescription());
        return storeRepository.save(store);
    }

    // Lấy danh sách tất cả cửa hàng
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    // Lấy cửa hàng theo id
    public Store getStoreById(Long id) {
        return storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found"));
    }

    // Cập nhật cửa hàng
    public Store updateStore(Long id, StoreRequest request) {
        Store store = getStoreById(id);
        store.setName(request.getName());
        store.setLocation(request.getLocation());
        store.setDescription(request.getDescription());
        return storeRepository.save(store);
    }

    // Xóa cửa hàng
    public void deleteStore(Long id) {
        Store store = getStoreById(id);
        storeRepository.delete(store);
    }
}
