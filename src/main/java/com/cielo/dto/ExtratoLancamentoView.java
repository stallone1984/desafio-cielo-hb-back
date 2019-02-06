package com.cielo.dto;

import java.math.BigDecimal;

/**
 * Classe com os dados que serão exibidos na tela de consulta
 * de extratos de lançamentos.
 * 
 * @author heitor bernardino
 *
 */
import java.time.LocalDate;

public class ExtratoLancamentoView {

	private LocalDate dataLancamento;
	private LocalDate dataConfirmacao;
	private String descricao;
	private Long numero;
	private String situacao;
	private String dadosBancarios;
	private BigDecimal valorFinal;

	public ExtratoLancamentoView() {
		super();
	}

	public ExtratoLancamentoView(LocalDate dataLancamento, LocalDate dataConfirmacao, String descricao, Long numero,
			String situacao, String dadosBancarios, BigDecimal valorFinal) {
		super();
		this.dataLancamento = dataLancamento;
		this.dataConfirmacao = dataConfirmacao;
		this.descricao = descricao;
		this.numero = numero;
		this.situacao = situacao;
		this.dadosBancarios = dadosBancarios;
		this.valorFinal = valorFinal;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public LocalDate getDataConfirmacao() {
		return dataConfirmacao;
	}

	public void setDataConfirmacao(LocalDate dataConfirmacao) {
		this.dataConfirmacao = dataConfirmacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getDadosBancarios() {
		return dadosBancarios;
	}

	public void setDadosBancarios(String dadosBancarios) {
		this.dadosBancarios = dadosBancarios;
	}

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}

}
