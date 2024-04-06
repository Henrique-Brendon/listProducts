package br.com.henrique.system.config;

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
import br.com.henrique.system.services.util.ExcelFile;

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
    	List<Product> list = new ArrayList<>();
    	try {
    	    
    	    list.addAll(ExcelFile.iterar("intel.xlsx"));
    	    
    	    if (!list.isEmpty()) {
    	        System.out.println("Primeiro objeto: " + list.get(0).getName());
    	        
    			Sector[] sector = new Sector[list.size()];
    			CodList[] codList = new CodList[list.size()];
    			
    			for(int i = 0; i< list.size(); i++) {
    				sector[i] = new Sector().mapSetor(list.get(i).getName());
    				list.get(i).setSector(sector[i]);
    				sector[i].getProduct().add(list.get(i));
    				list.get(i).setCodList(codList[i] = new CodList(String.valueOf(list.get(i).getCodList())));
    				codList[i].getProduct().add(list.get(i));
    			}
    			
    			codListRepository.saveAll(Arrays.asList(codList));
    			sectorRepository.saveAll(Arrays.asList(sector));
    			productRepository.saveAll(list);
    	    } else {
    	        System.out.println("A lista está vazia.");
    	    }
    	} catch (Exception e) {
    	    System.out.println("Ocorreu uma exceção: " + e.getMessage());
    	    e.printStackTrace();
    	}
		
    }
}
