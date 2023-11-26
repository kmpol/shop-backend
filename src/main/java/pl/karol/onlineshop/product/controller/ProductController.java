package pl.karol.onlineshop.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.karol.onlineshop.product.model.Product;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/api/v1/products")
    public List<Product> getProducts() {
        return List.of(
            new Product("Apple iPhone13 Pro", "Phone", "but it please xD", new BigDecimal("999.90"), "PLN"),
            new Product("Apple MacBook Pro 13", "Laptop", "but it please xD", new BigDecimal("1999.90"), "PLN"),
            new Product("Apple Watch 2SE", "Watch", "but it please xD", new BigDecimal("299.90"), "PLN")
        );
    }

}
