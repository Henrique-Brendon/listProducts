package br.com.henrique.system.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.henrique.system.entities.Product;
import br.com.henrique.system.services.SectorService;

@RestController
@RequestMapping("/sector")
public class SectorController {
    
    private SectorService service;

    public SectorController(SectorService service) {
        this.service =  service;
    }
    
    @GetMapping("/hardware")
    public List<Product> getAllHardwareProductsSortedBySector() {
        return service.findAllHardwareSortedBySector();
    }
}
