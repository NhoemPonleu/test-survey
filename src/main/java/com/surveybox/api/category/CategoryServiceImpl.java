package com.surveybox.api.category;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category createCateroy(Category category) {

        return categoryRepository.save(category);

    }


    @Override
    public Category getCategoryById(Long id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("category with %d not found", id)));

        return category;
    }


    @Override
    public Category update(Long id, Category category) {

        Category categoryUpdate = getCategoryById(id);

        BeanUtils.copyProperties(category, categoryUpdate, "id");

        return categoryRepository.save(categoryUpdate);
    }


    @Override
    public List<Category> finAll() {

        List<Category> category = categoryRepository.findAll();

        return category;
    }


    @Override
    public void deleteById(Long id) {

        Category category = getCategoryById(id);

        categoryRepository.delete(category);
    }
}
