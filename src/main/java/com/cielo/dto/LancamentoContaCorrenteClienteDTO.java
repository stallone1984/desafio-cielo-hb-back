package com.cielo.dto;

import java.util.ArrayList;

/**
 * 
 * @author heitor bernardino
 *
 */
import java.util.List;

public class LancamentoContaCorrenteClienteDTO {

	private Long numeroRemessaBanco;
	private String nomeSituacaoRemessa;
	private String nomeTipoOperacao;
	private DadosDomicilioBancarioDTO dadosDomicilioBancario;
	private List<DadosAnaliticoLancamentoFinanceiroClienteDTO> dadosAnaliticoLancamentoFinanceiroCliente = new ArrayList<>();

	public LancamentoContaCorrenteClienteDTO() {
		super();
	}

	public LancamentoContaCorrenteClienteDTO(Long numeroRemessaBanco, String nomeSituacaoRemessa,
			String nomeTipoOperacao, DadosDomicilioBancarioDTO dadosDomicilioBancario,
			List<DadosAnaliticoLancamentoFinanceiroClienteDTO> dadosAnaliticoLancamentoFinanceiroCliente) {
		super();
		this.numeroRemessaBanco = numeroRemessaBanco;
		this.nomeSituacaoRemessa = nomeSituacaoRemessa;
		this.nomeTipoOperacao = nomeTipoOperacao;
		this.dadosDomicilioBancario = dadosDomicilioBancario;
		this.dadosAnaliticoLancamentoFinanceiroCliente = dadosAnaliticoLancamentoFinanceiroCliente;
	}


	public Long getNumeroRemessaBanco() {
		return numeroRemessaBanco;
	}

	public void setNumeroRemessaBanco(Long numeroRemessaBanco) {
		this.numeroRemessaBanco = numeroRemessaBanco;
	}

	public String getNomeSituacaoRemessa() {
		return nomeSituacaoRemessa;
	}

	public void setNomeSituacaoRemessa(String nomeSituacaoRemessa) {
		this.nomeSituacaoRemessa = nomeSituacaoRemessa;
	}

	public String getNomeTipoOperacao() {
		return nomeTipoOperacao;
	}

	public void setNomeTipoOperacao(String nomeTipoOperacao) {
		this.nomeTipoOperacao = nomeTipoOperacao;
	}

	public DadosDomicilioBancarioDTO getDadosDomicilioBancario() {
		return dadosDomicilioBancario;
	}

	public void setDadosDomicilioBancario(DadosDomicilioBancarioDTO dadosDomicilioBancario) {
		this.dadosDomicilioBancario = dadosDomicilioBancario;
	}

	public List<DadosAnaliticoLancamentoFinanceiroClienteDTO> getDadosAnaliticoLancamentoFinanceiroCliente() {
		return dadosAnaliticoLancamentoFinanceiroCliente;
	}

	public void setDadosAnaliticoLancamentoFinanceiroCliente(
			List<DadosAnaliticoLancamentoFinanceiroClienteDTO> dadosAnaliticoLancamentoFinanceiroCliente) {
		this.dadosAnaliticoLancamentoFinanceiroCliente = dadosAnaliticoLancamentoFinanceiroCliente;
	}

	
}
