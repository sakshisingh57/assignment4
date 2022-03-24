package com.productCatalogServiceApp.productCatalogService.repository;

import com.productCatalogServiceApp.productCatalogService.entity.Category;
import com.productCatalogServiceApp.productCatalogService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findByCategoryId(Integer categoryId);
    Category findByCategoryName(String categoryName);
}
