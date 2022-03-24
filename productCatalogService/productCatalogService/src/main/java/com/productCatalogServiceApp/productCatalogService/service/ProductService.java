package com.productCatalogServiceApp.productCatalogService.service;

import com.productCatalogServiceApp.productCatalogService.entity.Product;
import com.productCatalogServiceApp.productCatalogService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        List<Product> products = productRepository.findAll();
        products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId(product.getProductId());
        product1.setProductName(product.getProductName());
        product1.setQuantity(product.getQuantity());
        products.add(product1);
        productRepository.save(product);
        return product1;
    }

    public Product getProduct(Integer productId) {

        return productRepository.findByProductId(productId);

    }

    public List<Product> getAllProducts
            () {
        return productRepository.findAll();
    }

    public Product update(Product product, Integer productId) {
        Product getProduct = productRepository.findByProductId(productId);
        if (getProduct != null) {
            getProduct.setProductId(product.getProductId());
            getProduct.setProductName(product.getProductName());
            getProduct.setQuantity(product.getQuantity());
            productRepository.save(getProduct);
        }

        return product;

    }

    public void deleteProduct(Integer userId) {
        productRepository.deleteById(userId);


    }

    public Product findProduct(String productName)
    {
        return productRepository.findByProductName(productName);
    }





}
