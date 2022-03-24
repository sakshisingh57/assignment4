package com.productCatalogServiceApp.productCatalogService.controller;

import com.productCatalogServiceApp.productCatalogService.entity.Product;
import com.productCatalogServiceApp.productCatalogService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/prod")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody Product product)
    {
        return productService.createProduct(product);
    }

    @GetMapping("/product/{productId}")
    public Product getProduct(@PathVariable Integer productId)
    {
        return productService.getProduct(productId);
    }

    @GetMapping("/allProducts")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @PutMapping("/updateProduct/{productId}")
    public Product updateProducts(@RequestBody Product product,@PathVariable Integer productId)
    {
        return productService.update(product,productId);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public void deleteProduct(@PathVariable Integer productId)
    {
        productService.deleteProduct(productId);
    }

    @GetMapping("/product/productName/{productName}")
    public Product getProductByName1(@PathVariable("productName") String productName)
    {
        return productService.findProduct(productName);
    }
}
