package com.surveybox.api.category;


import java.util.List;

public interface CategoryService {
    Category createCateroy(Category category);

    Category getCategoryById(Long id);

    Category update(Long id, Category category);

    List<Category> finAll();

    void deleteById(Long id);
}
