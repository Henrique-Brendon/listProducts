package br.com.henrique.system.config;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.henrique.system.entities.Product;
import br.com.henrique.system.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    
    @Autowired
    private ProductRepository repository;

    @Override
    public void run(String... args) throws Exception {
        List<Product> list = new ArrayList<>();
        for(int i = 0; i<10; i++){
            list.add(new Product(null, "test", new BigDecimal("300.00"), new BigDecimal("300.00"), Instant.now(), Instant.now(), 2));
        }
        
        repository.saveAll(list);
    }
}
