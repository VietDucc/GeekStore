package com.vietduc.hello_spring_boot.service;

import com.vietduc.hello_spring_boot.dto.request.ProductVariantRequest;
import com.vietduc.hello_spring_boot.entity.Product;
import com.vietduc.hello_spring_boot.entity.ProductVariant;
import com.vietduc.hello_spring_boot.repository.ProductRepository;
import com.vietduc.hello_spring_boot.repository.ProductVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductVariantService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductVariantRepository variantRepository;

    // Tạo biến thể sản phẩm
    public ProductVariant createVariant(Long productId, ProductVariantRequest request) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ProductVariant variant = new ProductVariant();
        variant.setProduct(product);
        variant.setColor(request.getColor());
        variant.setSize(request.getSize());

        return variantRepository.save(variant);
    }

    // Lấy danh sách biến thể theo product
    public List<ProductVariant> getVariantsByProductId(Long productId) {
        return variantRepository.findByProductId(productId);
    }
}
