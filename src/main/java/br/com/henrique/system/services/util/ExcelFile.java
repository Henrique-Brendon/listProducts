package br.com.henrique.system.services.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.henrique.system.entities.products.Amd;
import br.com.henrique.system.entities.products.Intel;
import br.com.henrique.system.entities.products.Nvidia;
import br.com.henrique.system.services.exceptions.ExcelException;

public class ExcelFile {

	public static boolean xlExists(String path) {
		File file = new File(path);
		return file.exists();
	}

	public static void createFile(String path, Object object) throws ParseException {
		try (OutputStream file = new FileOutputStream(path)) {
			XSSFWorkbook book = new XSSFWorkbook();
			System.out.print("Created file");
			ExcelExporter p1 = new ExcelExporter();
			if (object instanceof Nvidia) {
				p1 = (Nvidia) object;
			} else if (object instanceof Amd) {
				p1 = (Amd) object;
			} else if (object instanceof Intel) {
				p1 = (Intel) object;
			}
			p1.toString();
			createSpreadsheets(book, p1);
			book.write(file);
			book.close();
		} catch (IOException e) {
			throw new ExcelException("Error");
		}
	}

	private static void createSpreadsheets(XSSFWorkbook book, ExcelExporter prototypeObj) throws ParseException {
		for (int i = 1; i <= 12; i++) {
			String sheetName = (i < 10) ? "0" + i : String.valueOf(i);
			book.createSheet(sheetName);
			ExcelExporter obj = prototypeObj.createObject(book, sheetName, prototypeObj);
			obj.header(obj, sheetName);
		}
	}

	public static boolean isRegionMerged(XSSFSheet sheet, CellRangeAddress region) {
		int numMergedRegion = sheet.getNumMergedRegions();
		for (int i = 0; i < numMergedRegion; i++) {
			CellRangeAddress mergedRegion = sheet.getMergedRegion(i);
			if (mergedRegion.equals(region)) {
				return true;
			}
		}
		return false;
	}

	public static void createdCell(XSSFRow row, int coluna, Object valor) {
		XSSFCell cell = row.createCell(coluna);
		if (valor != null) {
			if (valor instanceof Number) {
				cell.setCellValue(((Number) valor).doubleValue());

			} else {
				cell.setCellValue(valor.toString());
			}
		}
	}
}
