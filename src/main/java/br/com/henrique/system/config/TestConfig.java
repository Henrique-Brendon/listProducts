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
        Product product = new Product(null, "GTX 980", new BigDecimal("500.00"), new BigDecimal("500.00"), DateTransform.formatarData("05/02/2018"), DateTransform.formatarData("18/03/2018"), 10);
        Sector sector =  new Sector(null, "teste");
        CodList codList = new CodList(null, "teste");
        
        codList.getProduct().add(product);
        sector.getProduct().add(product);
        
        product.setSector(sector);
        product.setCodList(codList);

        sectorRepository.save(sector);
        codListRepository.save(codList);
        productRepository.save(product);
    }
}
