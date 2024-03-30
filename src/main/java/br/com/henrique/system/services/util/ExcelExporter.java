package br.com.henrique.system.services.util;

import java.io.Serializable;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ExcelExporter implements Serializable{
	private XSSFSheet sheet;
	private XSSFCellStyle style;
	private XSSFFont font;
	private XSSFRow row;
	private XSSFCell cell;
	
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
	
	
}
