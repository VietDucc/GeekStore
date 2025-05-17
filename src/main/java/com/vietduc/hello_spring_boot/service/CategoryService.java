package com.vietduc.hello_spring_boot.service;

import com.vietduc.hello_spring_boot.dto.request.CategoryRequest;
import com.vietduc.hello_spring_boot.entity.Category;
import com.vietduc.hello_spring_boot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Trả về DTO sau khi tạo
    public Category createCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        category.setImageSrc(categoryRequest.getImageSrc());
        return categoryRepository.save(category);
    }

    // Trả về danh sách DTO
    public List<Category> getAllCategories() {
       return categoryRepository.findAll();
    }


}

