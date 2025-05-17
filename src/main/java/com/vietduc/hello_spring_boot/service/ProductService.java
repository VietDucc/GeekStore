package com.vietduc.hello_spring_boot.service;

import com.vietduc.hello_spring_boot.dto.request.ProductRequest;
import com.vietduc.hello_spring_boot.entity.Category;
import com.vietduc.hello_spring_boot.entity.Product;
import com.vietduc.hello_spring_boot.repository.CategoryRepository;
import com.vietduc.hello_spring_boot.repository.ProductRepository;
import com.vietduc.hello_spring_boot.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // Tạo sản phẩm với id category
    public Product createProduct(Long categoryId, ProductRequest request) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setDescription(request.getDescription());
        product.setDiscountPercent(request.getDiscountPercent());
        product.setImageSrc(request.getImageSrc());
        product.setCategory(category);

        return productRepository.save(product);
    }

    // Lấy danh sách sản phẩm theo categoryId
    public List<Product> getProductsByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public void updateProductPartial(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Optional.ofNullable(request.getName()).ifPresent(product::setName);
        Optional.ofNullable(request.getPrice()).ifPresent(product::setPrice);
        Optional.ofNullable(request.getDescription()).ifPresent(product::setDescription);
        Optional.ofNullable(request.getDiscountPercent()).ifPresent(product::setDiscountPercent);
        Optional.ofNullable(request.getImageSrc()).ifPresent(product::setImageSrc);

        productRepository.save(product);
    }


    public void updateDiscountPercent(Long productId, BigDecimal discountPercent) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setDiscountPercent(discountPercent);

        productRepository.save(product);
    }

    public List<Product> search(String keyword, Integer minPrice, Integer maxPrice, Long categoryId) {
        Specification<Product> spec = Specification.where(null);

        if (keyword != null && !keyword.isBlank()) {
            spec = spec.and(ProductSpecification.hasKeyword(keyword));
        }
        if (minPrice != null && maxPrice != null) {
            spec = spec.and(ProductSpecification.priceBetween(minPrice, maxPrice));
        }
        if (categoryId != null) {
            spec = spec.and(ProductSpecification.inCategory(categoryId));
        }

        return productRepository.findAll(spec);
    }


}
