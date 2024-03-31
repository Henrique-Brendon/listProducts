package br.com.henrique.system;

import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.henrique.system.entities.products.Nvidia;
import br.com.henrique.system.services.util.ExcelFile;

@SpringBootApplication
public class SystemApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SystemApplication.class, args);
	
	}

}
