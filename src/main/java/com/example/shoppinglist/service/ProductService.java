package com.example.shoppinglist.service;

import com.example.shoppinglist.models.Product;
import com.example.shoppinglist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product save(String title) {
        Product product = new Product(title);
        try {
            productRepository.save(product);
        } catch (Exception e) { return null; }
        return product;
    }

    public void update(Long id, String title, boolean isBought) {
        Product product = new Product(id, title);
        product.setBought(isBought);
        productRepository.save(product);
    }

    public int delete(Long id) {
        Product product = productRepository.findById(id).get();
        try {
            productRepository.delete(product);
        } catch (Exception e) { return -1; }
        return 0;
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Iterable<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
