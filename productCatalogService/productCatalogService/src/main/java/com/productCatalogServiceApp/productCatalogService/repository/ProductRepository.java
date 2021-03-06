package com.productCatalogServiceApp.productCatalogService.repository;

import com.productCatalogServiceApp.productCatalogService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByProductId(Integer productId);
    Product findByProductName(String productName);
}
