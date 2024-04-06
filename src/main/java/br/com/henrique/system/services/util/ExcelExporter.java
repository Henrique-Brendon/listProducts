package br.com.henrique.system.services.util;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.henrique.system.entities.CodList;
import br.com.henrique.system.entities.Product;
import br.com.henrique.system.entities.impl.ProductInterface;
import br.com.henrique.system.entities.products.Amd;
import br.com.henrique.system.entities.products.Intel;
import br.com.henrique.system.entities.products.Nvidia;
import br.com.henrique.system.services.exceptions.ExcelException;

public class ExcelExporter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private XSSFSheet sheet;
	private XSSFCellStyle style;
	private XSSFFont font;
	private XSSFRow row;
	private XSSFCell cell;
	
	public ExcelExporter() {}
	
	public ExcelExporter(XSSFSheet sheet, XSSFCellStyle style, XSSFFont font, XSSFRow row, XSSFCell cell) {
		this.sheet = sheet;
		this.style = style;
		this.font = font;
		this.row = row;
		this.cell = cell;
	}

	public XSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(XSSFSheet sheet) {
		this.sheet = sheet;
	}

	public XSSFCellStyle getStyle() {
		return style;
	}

	public void setStyle(XSSFCellStyle style) {
		this.style = style;
	}

	public XSSFFont getFont() {
		return font;
	}

	public void setFont(XSSFFont font) {
		this.font = font;
	}

	public XSSFRow getRow() {
		return row;
	}

	public void setRow(XSSFRow row) {
		this.row = row;
	}

	public XSSFCell getCell() {
		return cell;
	}

	public void setCell(XSSFCell cell) {
		this.cell = cell;
	}
	
	public ExcelExporter createObject(XSSFWorkbook book, String info, ExcelExporter object) {
		object.setSheet(book.getSheet(info));
		object.setStyle(book.createCellStyle());
		object.setFont(book.createFont());
		((ProductInterface) object).logo(object);
		genericHeader(object);
		return object;
	}

	private void genericHeader(ExcelExporter product) {
		product.setRow(product.getSheet().createRow(4));
		String[] atributos = new String[] { "Name", "Characteristics", "url", "cost", "priçe", "Product input",
				"Product output", "Sector", "Product code", "Quantity" };
		for (int i = 0; i < atributos.length; i++) {
			product.setCell(product.getRow().createCell(i));
			product.getCell().setCellValue(atributos[i]);
			((ProductInterface) product).secondaryStyle(product, 0);
		}
	}

	public void header(ExcelExporter obj, String sheetName) throws ParseException {
		int numRow = 2;
		int cell = 0;
		obj.setRow(obj.getSheet().createRow(numRow));
		obj.setCell(obj.getRow().createCell(cell));
		obj.getCell().setCellValue("Product code:");
		((ProductInterface) obj).applyStyle(obj, 0);

		CellRangeAddress c1 = new CellRangeAddress(numRow, numRow, cell + 1, 9);
		if (!ExcelFile.isRegionMerged(obj.getSheet(), c1)) {
			obj.getSheet().addMergedRegion(c1);
		}

		obj.setCell(obj.getRow().createCell(cell + 1));
		Product aux = new Product();
		aux.setCodList(new CodList(generateRandomString()));
		obj.getCell().setCellValue(aux.getCodList().getCodList());

		((ProductInterface) obj).applyStyle(obj, 1);

		numRow++;

		obj.setRow(obj.getSheet().createRow(numRow));
		obj.setCell(obj.getRow().createCell(cell));

		obj.getCell().setCellValue("Date:");
		((ProductInterface) obj).applyStyle(obj, 0);

		c1 = new CellRangeAddress(numRow, numRow, cell + 1, 9);
		if (!ExcelFile.isRegionMerged(obj.getSheet(), c1)) {
			obj.getSheet().addMergedRegion(c1);
		}

		obj.setCell(obj.getRow().createCell(cell + 1));

		obj.getCell().setCellValue(dateSheetName(sheetName));
		((ProductInterface) obj).applyStyle(obj, 1);

		for (int j = 0; j < 9; j++) {
			obj.getSheet().autoSizeColumn(j);
		}

		catalizador(obj, sheetName, aux);
	}
	
	public void catalizador(ExcelExporter product, String sheetName, Product aux) throws ParseException {
		String aleatoria = aux.getCodList().getCodList();
		List<Product> listProduto = ((ProductInterface) product).startProduct();
		int rowIndex = 5;
		String date = dateSheetName(sheetName);

		for (Product produtoAux : listProduto) {
			produtoAux.setDateEntry(DateTransform.formatarData(date));
			product.setRow(product.getSheet().createRow(rowIndex++));
	
			ExcelFile.createdCell(product.getRow(), 0, produtoAux.getName());
			ExcelFile.createdCell(product.getRow(), 1, produtoAux.getCharacteristics());
			ExcelFile.createdCell(product.getRow(), 2, produtoAux.getImgUrl());
			ExcelFile.createdCell(product.getRow(), 3, produtoAux.getCost() + "0 R$");
			ExcelFile.createdCell(product.getRow(), 4, produtoAux.getPrice() + "0 R$");
			ExcelFile.createdCell(product.getRow(), 5, produtoAux.getDateEntry());
			//ExcelFile.createdCell(product.getRow(), 6, new String("NULL"));
			ExcelFile.createdCell(product.getRow(), 7, produtoAux.getSector().getName());
			ExcelFile.createdCell(product.getRow(), 8, aleatoria);
			ExcelFile.createdCell(product.getRow(), 9, new Random().nextInt(20));
		}

		for (int j = 0; j < 9; j++) {
			product.getSheet().autoSizeColumn(j);
		}
	}
	
	public String dateSheetName(String sheetName) {
		if (sheetName != null && sheetName.matches("\\d+") && Integer.parseInt(sheetName) >= 1
				&& Integer.parseInt(sheetName) <= 12) {
			return String.format("12/%02d/2018", Integer.parseInt(sheetName));
		}
		return null;
	}

	public static String generateRandomString() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuilder sb = new StringBuilder(10);
		for (int i = 0; i < 10; i++) {
			int index = random.nextInt(characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}


}
