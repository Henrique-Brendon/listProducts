package br.com.henrique.system;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.henrique.system.entities.Product;
import br.com.henrique.system.services.util.ExcelFile;

@SpringBootApplication
public class SystemApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SystemApplication.class, args);
		//ExcelFile.createFile("intel.xlsx", new Intel());
		List<Product> list = new ArrayList<>();
		list.addAll(ExcelFile.iterar("intel.xlsx"));
		
		for(Product p: list) {
			System.out.println(p);
		}
	}

}
