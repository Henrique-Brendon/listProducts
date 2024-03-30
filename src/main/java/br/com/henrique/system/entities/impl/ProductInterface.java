package br.com.henrique.system.entities.impl;

import java.util.List;

import br.com.henrique.system.entities.Product;
import br.com.henrique.system.services.util.ExcelExporter;

public interface ProductInterface {
	List<Product> startProduct();
    void logo(ExcelExporter product);
    void applyStyle(ExcelExporter obj, int num);
    void secondaryStyle(ExcelExporter obj, int num);
    
}
