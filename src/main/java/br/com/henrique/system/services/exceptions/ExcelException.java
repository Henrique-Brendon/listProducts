package br.com.henrique.system.services.exceptions;

public class ExcelException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ExcelException(String info) {
		super(info);
	}
}
