package com.UserServiceApp.userservice.service;

import com.UserServiceApp.userservice.Request.Category;
import com.UserServiceApp.userservice.Request.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-catalog-service", url="http://localhost:8083")
public interface ProductCatalogServiceClient {

    @GetMapping("/api/prod/allProducts")
   public List<Product> getProduct();

    @GetMapping("/api/prod/product/{productId}")
    public Product getProductByProductId(@PathVariable("productId") Integer productId);

    @GetMapping("/api/prod/product/productName/{productName}")
    public Product getProductByProductName(@PathVariable String productName);

    @GetMapping("/api/cate/category/categoryName/{categoryName}")
    public Category getCategoryByCategoryName(@PathVariable String categoryName);

}
