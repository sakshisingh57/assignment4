package com.productCatalogServiceApp.productCatalogService.controller;

import com.productCatalogServiceApp.productCatalogService.entity.Category;
import com.productCatalogServiceApp.productCatalogService.entity.Product;
import com.productCatalogServiceApp.productCatalogService.repository.CategoryRepository;
import com.productCatalogServiceApp.productCatalogService.service.CategoryService;
import com.productCatalogServiceApp.productCatalogService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/cate")
public class CetegoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/createCategory")
    public Category createCategory(@RequestBody Category category)
    {
        return categoryService.createCategory(category);
    }

    @GetMapping("/category/{categoryId}")
    public Category getCategory(@PathVariable Integer categoryId)
    {
        return categoryService.getCategory(categoryId);
    }

    @GetMapping("/allCategory")
    public List<Category> getAllCategory()
    {
        return categoryService.getAllCategories();
    }

    @PutMapping("/updateCategory/{categoryId}")
    public Category updateCategory(@RequestBody Category category,@PathVariable Integer categoryId)
    {
        return categoryService.update(category,categoryId);
    }

    @DeleteMapping("/deleteCategory/{categoryId}")
    public void deleteCategory(@PathVariable Integer categoryId)
    {
        categoryService.deleteUser(categoryId);
    }

    @GetMapping("/category/categoryName/{categoryName}")
    public Category getProductByName(@PathVariable String categoryName)
    {
        return categoryService.findCategory(categoryName);
    }
}
