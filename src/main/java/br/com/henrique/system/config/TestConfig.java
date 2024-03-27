package br.com.henrique.system.config;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.henrique.system.entities.CodList;
import br.com.henrique.system.entities.Product;
import br.com.henrique.system.entities.Sector;
import br.com.henrique.system.repositories.CodListRepository;
import br.com.henrique.system.repositories.ProductRepository;
import br.com.henrique.system.repositories.SectorRepository;
import br.com.henrique.system.services.util.DateTransform;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SectorRepository sectorRepository;

    @Autowired
    private CodListRepository codListRepository;


    @Override
    public void run(String... args) throws Exception {
        Product p1 = new Product(null, "GTX 980", new BigDecimal("500.00"), new BigDecimal("500.00"), DateTransform.formatarData("05/02/2018"), DateTransform.formatarData("18/03/2018"), 10);
        Sector s1 = new Sector().mapSetor(p1.getName());
        p1.setSector(s1);
        s1.getProduct().add(p1);
        sectorRepository.save(s1);
        productRepository.save(p1);

        Product p2 = new Product(null, "Mouse", new BigDecimal("40.00"), new BigDecimal("120.00"), DateTransform.formatarData("05/02/2018"), DateTransform.formatarData("18/03/2018"), 10);
        Sector s2 = new Sector().mapSetor(p2.getName());
        p2.setSector(s2);
        s2.getProduct().add(p2);
        sectorRepository.save(s2);
        productRepository.save(p2);

        Product p3 = new Product(null, "iPhone 12", new BigDecimal("300.00"), new BigDecimal("1000.00"), DateTransform.formatarData("05/02/2018"), DateTransform.formatarData("18/03/2018"), 10);
        Sector s3 = new Sector().mapSetor(p2.getName());
        p3.setSector(s3);
        s3.getProduct().add(p3);
        sectorRepository.save(s3);
        productRepository.save(p3);
    }
}
