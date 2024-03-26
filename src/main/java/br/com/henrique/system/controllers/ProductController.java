package br.com.henrique.system.controllers;

import java.math.BigDecimal;
import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.henrique.system.entities.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @GetMapping
    public ResponseEntity<Product> findALl(){
        Product product = new Product(1L, "test", new BigDecimal("300.00"), new BigDecimal("300.00"), Instant.now(), Instant.now(), 2);
        return ResponseEntity.ok().body(product);
    }
}
