package com.cielo.exception;

public class DadoObrigatorioException extends RuntimeException{

	private static final long serialVersionUID = 5051924634639414916L;

	public DadoObrigatorioException(String message) {
		super(message);
	}
}
