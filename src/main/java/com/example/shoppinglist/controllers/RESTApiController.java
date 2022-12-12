package com.example.shoppinglist.controllers;

import com.example.shoppinglist.models.Product;
import net.minidev.json.JSONObject;
import com.example.shoppinglist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class RESTApiController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    private Iterable<Product> list() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    private Optional<Product> getById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable("id") Long id) {
        productService.delete(id);
    }

    @PostMapping("/update/{id}")
    private void update(@PathVariable("id") Long id) {
        var product = productService.findById(id);
        productService.update(id, product.get().getName(), product.get().isBought() ? false : true);
    }

    @PostMapping("/add")
    private ResponseEntity<String> addProduct(@RequestBody JSONObject jsonProduct) {
        var name = jsonProduct.get("productName").toString();
        productService.save(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
