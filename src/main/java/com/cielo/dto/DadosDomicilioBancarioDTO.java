package com.cielo.dto;

/**
 * 
 * @author heitor bernardino
 *
 */

public class DadosDomicilioBancarioDTO {

	private Integer codigoBanco;
	private Integer numeroAgencia;
	private String numeroContaCorrente;
	
	public DadosDomicilioBancarioDTO() {
		super();
	}

	public DadosDomicilioBancarioDTO(Integer codigoBanco, Integer numeroAgencia, String numeroContaCorrente) {
		super();
		this.codigoBanco = codigoBanco;
		this.numeroAgencia = numeroAgencia;
		this.numeroContaCorrente = numeroContaCorrente;
	}

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public Integer getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(Integer numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getNumeroContaCorrente() {
		return numeroContaCorrente;
	}

	public void setNumeroContaCorrente(String numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}

}
