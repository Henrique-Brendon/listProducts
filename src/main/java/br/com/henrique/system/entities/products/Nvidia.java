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
				new Product(null, "GTX 960", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("200.0"), new BigDecimal("300.0"), null, null, null),
				new Product(null, "GTX 970", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("400.0"), new BigDecimal("600.0"), null, null, null),
				new Product(null, "GTX 980", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("450.0"), new BigDecimal("700.0"), null, null, null),
				new Product(null, "GTX 1060", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("300.0"), new BigDecimal("500.0"), null, null, null),
				new Product(null, "GTX 1070", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("500.0"), new BigDecimal("800.0"), null, null, null),
				new Product(null, "GTX 1080", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("900.0"), new BigDecimal("1000.0"), null, null, null),
				new Product(null, "GTX 1080 TI", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("1200.0"), new BigDecimal("1500.0"), null, null, null),
				new Product(null, "RTX 2060", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("700.0"), new BigDecimal("1500.0"), null, null, null),
				new Product(null, "RTX 2060 SUPER", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("900.0"), new BigDecimal("1700.0"), null, null, null),
				new Product(null, "RTX 2070", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("1200.0"), new BigDecimal("1900.0"), null, null, null),
				new Product(null, "RTX 2080", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("800.0"), new BigDecimal("2300.0"), null, null, null),
				new Product(null, "RTX 2080 TI", "placa de vídeo", "http://wgfgfdgd.com", new BigDecimal("1300.0"), new BigDecimal("2500.0"), null, null, null))
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
