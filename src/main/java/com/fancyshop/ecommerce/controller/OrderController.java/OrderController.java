package com.fancyshop.ecommerce.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.fancyshop.ecommerce.model.Product;
import com.fancyshop.ecommerce.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000") // Adjust the origin as
public class OrderController {

    private final ProductRepository productRepository;

    public OrderController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/api/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/api/products/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    @PostMapping("/api/products")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/api/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }

    @DeleteMapping("/api/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
