package com.surveybox.api.category.web;

import com.surveybox.api.category.Category;
import com.surveybox.api.category.CategoryMapper;
import com.surveybox.api.category.CategoryService;
import com.surveybox.base.BaseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> createCategorys(@RequestBody CategoryDto categoryDto) {
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDto);
        //  CategoryDto categoryDto1 =categoryService.createCateroy(categoryDto);
        Category category1 = categoryService.createCateroy(category);
        return ResponseEntity.ok(category1);

    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findCategoryById(@PathVariable("id") Long id) {
        Category categoryDto = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryDto);
    }


    @PutMapping("{id}")
    public ResponseEntity<?> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryDto categoryDto) {
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDto);
        category = categoryService.update(id, category);
        return ResponseEntity.ok(CategoryMapper.INSTANCE.toDto(category));
    }


    @GetMapping
    public BaseApi<?> findAll() {
        List<Category> categories = categoryService.finAll();
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .message("every thing is ok")
                .timeStamp(LocalDateTime.now())
                .data(categories)
                .status(true)
                .build();
    }


    @DeleteMapping("{id}")
    public BaseApi<?> deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
        return BaseApi.builder()
                .code(HttpStatus.OK.value())
                .message("every thing is ok")
                .timeStamp(LocalDateTime.now())
                .data("your id delete is:" + id)
                .status(true)
                .build();
    }
}
