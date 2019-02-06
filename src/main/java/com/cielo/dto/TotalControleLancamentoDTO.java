package com.cielo.dto;

import java.math.BigDecimal;

/**
 * 
 * @author heitor bernardino
 *
 */

public class TotalControleLancamentoDTO {

	private Long quantidadeLancamentos;
	private Long quantidadeRemessas;
	private BigDecimal valorLancamentos;

	public TotalControleLancamentoDTO() {
		super();
	}

	public TotalControleLancamentoDTO(Long quantidadeLancamentos, Long quantidadeRemessas,
			BigDecimal valorLancamentos) {
		super();
		this.quantidadeLancamentos = quantidadeLancamentos;
		this.quantidadeRemessas = quantidadeRemessas;
		this.valorLancamentos = valorLancamentos;
	}

	public Long getQuantidadeLancamentos() {
		return quantidadeLancamentos;
	}

	public void setQuantidadeLancamentos(Long quantidadeLancamentos) {
		this.quantidadeLancamentos = quantidadeLancamentos;
	}

	public Long getQuantidadeRemessas() {
		return quantidadeRemessas;
	}

	public void setQuantidadeRemessas(Long quantidadeRemessas) {
		this.quantidadeRemessas = quantidadeRemessas;
	}

	public BigDecimal getValorLancamentos() {
		return valorLancamentos;
	}

	public void setValorLancamentos(BigDecimal valorLancamentos) {
		this.valorLancamentos = valorLancamentos;
	}

}
