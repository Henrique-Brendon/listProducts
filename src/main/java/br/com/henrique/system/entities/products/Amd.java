package br.com.henrique.system.entities.products;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import br.com.henrique.system.entities.Product;
import br.com.henrique.system.entities.Sector;
import br.com.henrique.system.entities.impl.ProductInterface;
import br.com.henrique.system.services.util.ExcelExporter;
import br.com.henrique.system.services.util.ExcelFile;

public class Amd extends ExcelExporter implements ProductInterface{
	private static final long serialVersionUID = 1L;
	
	public Amd() {}

	public Amd(XSSFSheet sheet, XSSFCellStyle style, XSSFFont font, XSSFRow row, XSSFCell cell) {
		super(sheet, style, font, row, cell);
	}

	@Override
	public List<Product> startProduct() {
		return Stream.of(
				new Product(null, "RYZEN 3 3200G", "Processador", "http://wgfgfdgd.com", new BigDecimal("100.0"), new BigDecimal("200.0"), null, null, null),
				new Product(null, "RYZEN 5 3500", "Processador", "http://wgfgfdgd.com", new BigDecimal("300.0"), new BigDecimal("500.0"), null, null, null),
				new Product(null, "RYZEN 5 3600", "Processador", "http://wgfgfdgd.com", new BigDecimal("350.0"), new BigDecimal("550.0"), null, null, null),
				new Product(null, "RYZEN 5 3600X", "Processador", "http://wgfgfdgd.com", new BigDecimal("400.0"), new BigDecimal("600.0"), null, null, null),
				new Product(null, "RYZEN 5 5500", "Processador", "http://wgfgfdgd.com", new BigDecimal("400.0"), new BigDecimal("550.0"), null, null, null),
				new Product(null, "RYZEN 5 5600", "Processador", "http://wgfgfdgd.com", new BigDecimal("500.0"), new BigDecimal("700.0"), null, null, null),
				new Product(null, "RYZEN 5600G", "Processador", "http://wgfgfdgd.com", new BigDecimal("500.0"), new BigDecimal("750.0"), null, null, null),
				new Product(null, "RYZEN 5 5700", "Processador", "http://wgfgfdgd.com", new BigDecimal("600.0"), new BigDecimal("1000.0"), null, null, null),
				new Product(null, "RYZEN 5 5800", "Processador", "http://wgfgfdgd.com", new BigDecimal("650.0"), new BigDecimal("1050.0"), null, null, null),
				new Product(null, "RYZEN 5 5800X", "Processador", "http://wgfgfdgd.com", new BigDecimal("800.0"), new BigDecimal("1200.0"), null, null, null),
				new Product(null, "RX 550", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("300.0"), new BigDecimal("350.0"), null, null, null),
				new Product(null, "RX 560", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("350.0"), new BigDecimal("500.0"), null, null, null),
				new Product(null, "RX 570", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("450.0"), new BigDecimal("600.0"), null, null, null),
				new Product(null, "RX 580", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("500.0"), new BigDecimal("800.0"), null, null, null))
				.map(product -> {
					product.setSector(Sector.mapSetor(product.getName()));
					return product;
				}).collect(Collectors.toList());
	
	}

	@Override
	public void logo(ExcelExporter product) {
		CellRangeAddress c1 = new CellRangeAddress(1, 1, 0, 9);
		if (!ExcelFile.isRegionMerged(product.getSheet(), c1)) {
			product.getSheet().addMergedRegion(c1);
		}
		product.setRow(product.getSheet().createRow(1));
		product.setCell(product.getRow().createCell(0));
		product.getCell().setCellValue("Amd");
		product.getStyle().setAlignment(HorizontalAlignment.CENTER);
		product.getStyle().setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
		product.getStyle().setFillForegroundColor(IndexedColors.BLACK.getIndex());
		product.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
		product.getCell().getRow().setHeightInPoints(30);
		product.getFont().setColor(IndexedColors.RED.getIndex());
		product.getFont().setFontHeightInPoints((short) 30);
		product.getStyle().setFont(getFont());
		product.getCell().setCellStyle(getStyle());
	}

	@Override
	public void applyStyle(ExcelExporter obj, int num) {
		obj.setStyle(obj.getSheet().getWorkbook().createCellStyle());
		obj.setFont(obj.getSheet().getWorkbook().createFont());

		obj.getStyle().setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		obj.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
		obj.getFont().setColor(IndexedColors.WHITE.getIndex());
		if (num == 0) {
			obj.getStyle().setAlignment(HorizontalAlignment.LEFT);
		} else if (num == 1) {
			obj.getStyle().setAlignment(HorizontalAlignment.RIGHT);

		}
		obj.getFont().setFontHeightInPoints((short) 13);
		obj.getStyle().setFont(obj.getFont());
		obj.getCell().setCellStyle(obj.getStyle());
	}

	@Override
	public void secondaryStyle(ExcelExporter obj, int num) {
		obj.setStyle(obj.getSheet().getWorkbook().createCellStyle());
		obj.setFont(obj.getSheet().getWorkbook().createFont());
		if (num == 0) {
			obj.getStyle().setFillForegroundColor(IndexedColors.BLACK.getIndex());
			obj.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
			obj.getFont().setColor(IndexedColors.RED.getIndex());
		} else if (num == 1) {
			obj.getStyle().setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
			obj.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
			obj.getFont().setColor(IndexedColors.WHITE.getIndex());
		}
		obj.getStyle().setFont(getFont());
		obj.getCell().setCellStyle(obj.getStyle());
	}
}
