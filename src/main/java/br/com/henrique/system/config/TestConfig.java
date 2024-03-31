package br.com.henrique.system.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    	List<Product> product = new ArrayList<>(); 
    	
    	Product[] p = new Product[]
			{
				new Product(null, "GTX 960", "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				new Product(null, "GTX 970",  "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				new Product(null, "GTX 980",  "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				new Product(null, "GTX 1080 TI",  "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				new Product(null, "RTX 2060 SUPER",  "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				new Product(null, "RTX 2070 TI",  "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				new Product(null, "RTX 2080 TI",  "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				new Product(null, "Samsung Galaxy S10",  "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				new Product(null, "Google Pixel 5",  "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				new Product(null, "iPhone 12",  "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				new Product(null, "Google Pixel 5",  "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				new Product(null, "RX 580",  "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				new Product(null, "RYZEN 5600G",  "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				new Product(null, "RYZEN 5 5700",  "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				new Product(null, "Mouse",  "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				new Product(null, "Mouse",  "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				new Product(null, "Keyboard",  "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				new Product(null, "Headphones",  "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				new Product(null, "Headphones",  "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				new Product(null, "Headphones",  "", "", new BigDecimal("50.00"), new BigDecimal("50.00"), DateTransform.formatarData("05/11/2018"), DateTransform.formatarData("05/11/2018"), 10),
				
			};
    	
    	Sector[] s = new Sector[p.length];
    	CodList[] codList = new CodList[p.length];
    	for(int i = 0; i< p.length; i++) {
    		s[i] = new Sector().mapSetor(p[i].getName());
    		p[i].setSector(s[i]);
    		s[i].getProduct().add(p[i]);
    		p[i].setCodList(codList[i] = new CodList("test"));
    		codList[i].getProduct().add(p[i]);
    	}
    	
    	sectorRepository.saveAll(Arrays.asList(s));
    	codListRepository.saveAll(Arrays.asList(codList));
		productRepository.saveAll(Arrays.asList(p));
    }
}
