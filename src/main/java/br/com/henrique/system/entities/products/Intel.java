	package br.com.henrique.system.entities.products;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import br.com.henrique.system.entities.Product;
import br.com.henrique.system.entities.impl.ProductInterface;
import br.com.henrique.system.services.util.ExcelExporter;

public class Intel extends ExcelExporter implements ProductInterface{

	private static final long serialVersionUID = 1L;

	public Intel(XSSFSheet sheet, XSSFCellStyle style, XSSFFont font, XSSFRow row, XSSFCell cell) {
		super(sheet, style, font, row, cell);
	}

	@Override
	public List<Product> startProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void logo(ExcelExporter product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyStyle(ExcelExporter obj, int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void secondaryStyle(ExcelExporter obj, int num) {
		// TODO Auto-generated method stub
		
	}



}
