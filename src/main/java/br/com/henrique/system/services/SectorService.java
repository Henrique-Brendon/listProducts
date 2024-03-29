package br.com.henrique.system.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.henrique.system.entities.Product;
import br.com.henrique.system.entities.Sector;
import br.com.henrique.system.entities.enums.SectorName;
import br.com.henrique.system.repositories.ProductRepository;
import br.com.henrique.system.repositories.SectorRepository;

@Service
public class SectorService {
    
	@Autowired
	ProductRepository productRepository;
	
    private SectorRepository repository;

    public SectorService(SectorRepository repository) {
        this.repository = repository;
    }
    
    public List<Product> findAllHardwareSortedBySector(){
        List<Product> hardwareProducts = new ArrayList<>();
        List<Sector> sectors = repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        
        for (Sector sector : sectors) {
            for (Product product : sector.getProduct()) {
                if (product.getSector().getName().equals(SectorName.HARDWARE)) {
                    hardwareProducts.add(product);
                }
            }
        }
        
        return hardwareProducts;
}
}
