package com.vietduc.hello_spring_boot.controller;

import com.vietduc.hello_spring_boot.dto.request.DiscountPercentRequest;
import com.vietduc.hello_spring_boot.dto.request.ProductRequest;
import com.vietduc.hello_spring_boot.entity.Product;
import com.vietduc.hello_spring_boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Tạo sản phẩm mới với id category
    @PostMapping
    public Product createProduct(@RequestParam Long categoryId,@RequestBody ProductRequest request) {
        return productService.createProduct(categoryId, request);
    }

    // Lấy sản phẩm theo categoryId
    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable Long categoryId) {
        return productService.getProductsByCategoryId(categoryId);
    }
    //Cập nhật tất cả Product
    @PutMapping("/{productId}")
    public ResponseEntity<String> updateProductPartial(@PathVariable Long productId, @RequestBody ProductRequest request) {
        productService.updateProductPartial(productId, request);
        return ResponseEntity.ok("Successful");
    }

    @PatchMapping("/{productId}/discount")
    public ResponseEntity<String> updateDiscountPercent(@PathVariable Long productId, @RequestBody DiscountPercentRequest discountRequest) {
        productService.updateDiscountPercent(productId, discountRequest.getDiscountPercent());
        return ResponseEntity.ok("Discount percent updated successfully");
    }
    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) Integer maxPrice,
            @RequestParam(required = false) Long categoryId
    ) {
        return productService.search(keyword, minPrice, maxPrice, categoryId);
    }
}
