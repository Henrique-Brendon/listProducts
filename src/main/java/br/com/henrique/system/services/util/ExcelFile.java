package br.com.henrique.system.services.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.henrique.system.entities.CodList;
import br.com.henrique.system.entities.Product;
import br.com.henrique.system.entities.Sector;
import br.com.henrique.system.entities.enums.SectorName;
import br.com.henrique.system.entities.products.Amd;
import br.com.henrique.system.entities.products.Intel;
import br.com.henrique.system.entities.products.Nvidia;
import br.com.henrique.system.services.exceptions.ExcelException;

public class ExcelFile {

	public static boolean xlExists(String path) {
		File file = new File(path);
		return file.exists();
	}

	public static void createFile(String path, ExcelExporter object) throws ParseException {
		try (OutputStream file = new FileOutputStream(path)) {
			XSSFWorkbook book = new XSSFWorkbook();
			System.out.print("Created file");
			check(object);
			object.toString();
			createSpreadsheets(book, object);
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

	public static List<Product> iterar(String path) {
	    List<Product> list = new ArrayList<>();
	    try (FileInputStream file = new FileInputStream(path)) {
	        XSSFWorkbook book = new XSSFWorkbook(file);
	        for(int a = 0; a<12; a++) {
		        int dataBegins = 5;
		        XSSFSheet sheet = book.getSheetAt(a);
		        int lastRow = sheet.getLastRowNum();
		        System.out.println("File: " + a);
		        for (int i = dataBegins; i <= lastRow; i++) { 
		            XSSFRow row = sheet.getRow(i);
		            if (row != null) {
		                Product product = new Product();
		                for (int j = 0; j < 9; j++) {
		                    XSSFCell cell = row.getCell(j);
		                    if (cell != null) {
		                        switch (j) {
		                            case 0:
		                                product.setName(cell.getStringCellValue());
		                                break;
		                            case 1:
		                                product.setCharacteristics(cell.getStringCellValue());
		                                break;
		                            case 2:
		                                product.setImgUrl(cell.getStringCellValue());
		                                break;
		                            case 3:
		                                product.setCost(formatPrice(cell.getStringCellValue()));
		                                break;
		                            case 4:
		                                product.setPrice(formatPrice(cell.getStringCellValue()));
		                                break;
		                            case 5:
		                                product.setDateEntry(DateTransform.formatarData(cell.getStringCellValue()));
		                                break;
		                            case 6:
		                                if (cell != null) {
		                                    product.setDateExit(DateTransform.formatarData(cell.getStringCellValue()));
		                                }
		                                break;
		                            case 7:
		                                product.setSector(new Sector(SectorName.valueOf(cell.getStringCellValue())));
		                                break;
		                            case 8:
		                                product.setCodList(new CodList(cell.getStringCellValue()));
		                                break;
		                        }
		                    }
		                }
		                XSSFCell cell = row.getCell(9);
		                if (cell != null && cell.getNumericCellValue() > 0) {
		                    for (int h = 0; h < cell.getNumericCellValue(); h++) {
		                        list.add(product);
		                    }
		                } else {
		                    list.add(product);
		                }
		            }
		        }
	    }
	        return list;
	    } catch (IOException e) {
	        System.out.println(e.getMessage());
	    }
	    return null;
	}
	
	private static ExcelExporter check(ExcelExporter obj) {
		if (obj instanceof Nvidia) {
			return new Nvidia();
		} else if (obj instanceof Amd) {
			return new Amd();
		} else if (obj instanceof Intel) {
			return new Intel();
		}else {
			throw new ExcelException("No instances found");
		}
	}
	
	private static BigDecimal formatPrice(String valor) {
		String valorLimpo = valor.replaceAll("[^\\d.]", "");
		return new BigDecimal(valorLimpo);
	}
}
