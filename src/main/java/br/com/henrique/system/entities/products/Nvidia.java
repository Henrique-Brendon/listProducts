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

public class Nvidia extends ExcelExporter implements ProductInterface{
	private static final long serialVersionUID = 1L;
	
	public Nvidia() {}

	public Nvidia(XSSFSheet sheet, XSSFCellStyle style, XSSFFont font, XSSFRow row, XSSFCell cell) {
		super(sheet, style, font, row, cell);
	}

	@Override
	public List<Product> startProduct() {
		return Stream.of( // data
				new Product(null, "GTX 960", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("200.00"), new BigDecimal("300.00"), null, null),
				new Product(null, "GTX 970", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("400.00"), new BigDecimal("600.00"), null, null),
				new Product(null, "GTX 980", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("450.00"), new BigDecimal("700.00"), null, null),
				new Product(null, "GTX 1060", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("300.00"), new BigDecimal("500.00"), null, null),
				new Product(null, "GTX 1070", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("500.00"), new BigDecimal("800.00"), null, null),
				new Product(null, "GTX 1080", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("900.00"), new BigDecimal("1000.00"), null, null),
				new Product(null, "GTX 1080 TI", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("1200.00"), new BigDecimal("1500.00"), null, null),
				new Product(null, "RTX 2060", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("700.00"), new BigDecimal("1500.00"), null, null),
				new Product(null, "RTX 2060 SUPER", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("900.00"), new BigDecimal("1700.00"), null, null),
				new Product(null, "RTX 2070", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("1200.00"), new BigDecimal("1900.00"), null, null),
				new Product(null, "RTX 2080", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("800.00"), new BigDecimal("2300.00"), null, null),
				new Product(null, "RTX 2080 TI", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("1300.00"), new BigDecimal("2500.00"), null, null),
				new Product(null, "RTX 3060", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("1500.00"), new BigDecimal("3000.00"), null, null),
				new Product(null, "RTX 3060 TI", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("2000.00"), new BigDecimal("3400.00"), null, null),
				new Product(null, "RTX 3070", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("2400.00"), new BigDecimal("3800.00"), null, null),
				new Product(null, "RTX 3070 TI", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("2700.00"), new BigDecimal("4200.00"), null, null),
				new Product(null, "RTX 3080", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("3000.00"), new BigDecimal("4800.00"), null, null),
				new Product(null, "RTX 3080 TI", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("3500.00"), new BigDecimal("5200.00"), null, null),
				new Product(null, "RTX 3090", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("4000.00"), new BigDecimal("5500.00"), null, null),
				new Product(null, "RTX 3090 TI", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("4300.00"), new BigDecimal("6000.00"), null, null),
				new Product(null, "RTX 4060", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("1800.00"), new BigDecimal("3500.00"), null, null),
				new Product(null, "RTX 4060 TI", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("2000.00"), new BigDecimal("3700.00"), null, null),
				new Product(null, "RTX 4070", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("2800.00"), new BigDecimal("4200.00"), null, null),
				new Product(null, "RTX 4070 TI", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("3000.00"), new BigDecimal("4800.00"), null, null),
				new Product(null, "RTX 4080", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("3800.00"), new BigDecimal("5800.00"), null, null),
				new Product(null, "RTX 4080 TI", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("4200.00"), new BigDecimal("6200.00"), null, null),
				new Product(null, "RTX 4090", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("5000.00"), new BigDecimal("1200.00"), null, null),
				new Product(null, "RTX 4090 TI", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("6000.00"), new BigDecimal("14000.00"), null, null))
				.map(Produto -> {
					Produto.setSector(Sector.mapSetor(Produto.getName()));
					return Produto;
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
		product.getCell().setCellValue("Nvidia");

		product.getStyle().setAlignment(HorizontalAlignment.CENTER);
		product.getStyle().setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
		product.getStyle().setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		product.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
		product.getCell().getRow().setHeightInPoints(30);
		product.getFont().setColor(IndexedColors.BLACK.getIndex());
		product.getFont().setFontHeightInPoints((short) 30);
		product.getStyle().setFont(getFont());
		product.getCell().setCellStyle(getStyle());
	}

	@Override
	public void applyStyle(ExcelExporter obj, int num) {
		obj.setStyle(obj.getSheet().getWorkbook().createCellStyle());
		obj.setFont(obj.getSheet().getWorkbook().createFont());

		obj.getStyle().setFillForegroundColor(IndexedColors.GREEN.getIndex());
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
			obj.getStyle().setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
			obj.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
			obj.getFont().setColor(IndexedColors.BLACK.getIndex());
		} else if (num == 1) {
			obj.getStyle().setFillForegroundColor(IndexedColors.GREEN.getIndex());
			obj.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
			obj.getFont().setColor(IndexedColors.WHITE.getIndex());
		}
		obj.getStyle().setFont(obj.getFont());
		obj.getCell().setCellStyle(obj.getStyle());
	}

}
