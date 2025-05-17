package com.vietduc.hello_spring_boot.controller;

import com.vietduc.hello_spring_boot.dto.request.ProductVariantRequest;
import com.vietduc.hello_spring_boot.entity.ProductVariant;
import com.vietduc.hello_spring_boot.service.ProductVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-variants")
public class ProductVariantController {

    @Autowired
    private ProductVariantService variantService;

    // POST: Tạo variant mới cho productId
    @PostMapping
    public ProductVariant createVariant(@RequestParam Long productId, @RequestBody ProductVariantRequest request) {
        return variantService.createVariant(productId, request);
    }

    // GET: Lấy tất cả variant theo productId
    @GetMapping("/product/{productId}")
    public List<ProductVariant> getVariantsByProduct(@PathVariable Long productId) {
        return variantService.getVariantsByProductId(productId);
    }
}
