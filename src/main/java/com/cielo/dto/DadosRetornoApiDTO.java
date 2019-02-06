package com.cielo.dto;

/**
 * 
 * @author heitor bernardino
 *
 */

public class DadosRetornoApiDTO {

	private boolean sucesso;
	private String mensagem;
	private Object retorno;

	public DadosRetornoApiDTO() {
		super();
	}

	public DadosRetornoApiDTO(boolean sucesso, String mensagem, Object retorno) {
		super();
		this.sucesso = sucesso;
		this.mensagem = mensagem;
		this.retorno = retorno;
	}

	public boolean isSucesso() {
		return sucesso;
	}

	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Object getRetorno() {
		return retorno;
	}

	public void setRetorno(Object retorno) {
		this.retorno = retorno;
	}

}
