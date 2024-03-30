package br.com.henrique.system.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.henrique.system.entities.Product;
import br.com.henrique.system.entities.Sector;
import br.com.henrique.system.entities.enums.SectorName;
import br.com.henrique.system.services.SectorService;

@RestController
@RequestMapping("/sector")
public class SectorController {
    
    private SectorService service;

    public SectorController(SectorService service) {
        this.service =  service;
    }
    
    @GetMapping
    public ResponseEntity<List<Sector>> findAll() {
    	List<Sector> list = service.findAll();
    	return ResponseEntity.ok().body(list);
    }
    
    @GetMapping("/HARDWARE")
    public List<Product> getAllHardwareProductsSortedBySector() {
        return service.findAllProductsSortedBySector(SectorName.HARDWARE);
    }
    
    @GetMapping("/PERIPHELRALS")
    public List<Product> getAllPeriphelralsProductsSortedBySector() {
        return service.findAllProductsSortedBySector(SectorName.PERIPHELRALS);
    }
    
    @GetMapping("/SMARTHPHONES")
    public List<Product> getAllSmarthphonesProductsSortedBySector() {
        return service.findAllProductsSortedBySector(SectorName.SMARTHPHONES);
    }
    
    @GetMapping("/ELETRONICS")
    public List<Product> getAllEletronicsProductsSortedBySector() {
        return service.findAllProductsSortedBySector(SectorName.ELETRONICS);
    }
    
    
}
