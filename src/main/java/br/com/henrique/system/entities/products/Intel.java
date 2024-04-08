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

public class Intel extends ExcelExporter implements ProductInterface{

	private static final long serialVersionUID = 1L;
	
	public Intel() {}

	public Intel(XSSFSheet sheet, XSSFCellStyle style, XSSFFont font, XSSFRow row, XSSFCell cell) {
		super(sheet, style, font, row, cell);
	}

	@Override
	public List<Product> startProduct() {
		return Stream.of(
				new Product(null, "Intel Core i3-8100", "cpu", "http://wgfgfdgd.com", new BigDecimal("200.00"), new BigDecimal("300.00"), null, null),
				new Product(null, "Intel Core i5-6400", "cpu", "http://wgfgfdgd.com", new BigDecimal("400.00"), new BigDecimal("600.00"), null, null),
				new Product(null, "Intel Core i5-8500", "cpu", "http://wgfgfdgd.com", new BigDecimal("600.00"), new BigDecimal("700.00"), null, null),
				new Product(null, "Intel Core i5-8400", "cpu", "http://wgfgfdgd.com", new BigDecimal("550.00"), new BigDecimal("650.00"), null, null),
				new Product(null, "Intel Core i5-500", "cpu", "http://wgfgfdgd.com", new BigDecimal("100.00"), new BigDecimal("500.00"), null, null),
				new Product(null, "Intel Core i7-500", "cpu", "http://wgfgfdgd.com", new BigDecimal("300.00"), new BigDecimal("400.00"), null, null),
				new Product(null, "Intel Core i3-6400", "cpu", "http://wgfgfdgd.com", new BigDecimal("320.00"), new BigDecimal("480.00"), null, null))
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

		product.getCell().setCellValue("Intel");

		product.getStyle().setAlignment(HorizontalAlignment.CENTER);
		product.getStyle().setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
		product.getStyle().setFillForegroundColor(IndexedColors.BLUE.getIndex());
		product.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
		product.getCell().getRow().setHeightInPoints(30);
		product.getFont().setColor(IndexedColors.WHITE.getIndex());
		product.getFont().setFontHeightInPoints((short) 30);
		product.getStyle().setFont(getFont());
		product.getCell().setCellStyle(getStyle());
	}

	@Override
	public void applyStyle(ExcelExporter obj, int num) {
		obj.setStyle(obj.getSheet().getWorkbook().createCellStyle());
		obj.setFont(obj.getSheet().getWorkbook().createFont());

		obj.getStyle().setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		obj.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
		obj.getFont().setColor(IndexedColors.BLACK.getIndex());
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
		obj.getStyle().setAlignment(HorizontalAlignment.CENTER);
		if (num == 0) {

			obj.getStyle().setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
			obj.getStyle().setFillForegroundColor(IndexedColors.BLUE.getIndex());
			obj.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
			obj.getFont().setColor(IndexedColors.WHITE.getIndex());
		} else if (num == 1) {
			obj.getStyle().setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
			obj.getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
			obj.getFont().setColor(IndexedColors.BLACK.getIndex());
		}
		obj.getStyle().setFont(getFont());
		obj.getCell().setCellStyle(getStyle());
	}
	
}
