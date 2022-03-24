package com.productCatalogServiceApp.productCatalogService.service;

import com.productCatalogServiceApp.productCatalogService.entity.Category;
import com.productCatalogServiceApp.productCatalogService.entity.Product;
import com.productCatalogServiceApp.productCatalogService.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        List<Category> categories = categoryRepository.findAll();
        categories = new ArrayList<>();
        Category category1 = new Category();
        category1.setCategoryId(category.getCategoryId());
        category1.setCategoryName(category.getCategoryName());
        categories.add(category1);
        categoryRepository.save(category);
        return category1;
    }

    public Category getCategory(Integer categoryId) {

        return categoryRepository.findByCategoryId(categoryId);

    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category update(Category category, Integer categoryId) {
        Category getCategory = categoryRepository.findByCategoryId(categoryId);
        if (getCategory != null) {
            getCategory.setCategoryId(category.getCategoryId());
            getCategory.setCategoryName(category.getCategoryName());

            categoryRepository.save(getCategory);
        }

        return category;

    }

    public void deleteUser(Integer categoryId) {
        categoryRepository.deleteById(categoryId);


    }
    public Category findCategory(String categoryName)
    {
        return categoryRepository.findByCategoryName(categoryName);
    }

}
