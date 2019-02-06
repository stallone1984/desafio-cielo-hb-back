package com.cielo.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author heitor bernardino
 *
 */

public class ExtratoLancamentoDTO {

	private TotalControleLancamentoDTO totalControleLancamento;
	private List<ControleLancamentoDTO> listaControleLancamento = new ArrayList<>();
	private Integer indice;
	private Integer tamanhoPagina;
	private Integer totalElements;
	
	public ExtratoLancamentoDTO() {
		super();
	}

	public ExtratoLancamentoDTO(TotalControleLancamentoDTO totalControleLancamento,
			List<ControleLancamentoDTO> listaControleLancamento, Integer indice, Integer tamanhoPagina,
			Integer totalElements) {
		super();
		this.totalControleLancamento = totalControleLancamento;
		this.listaControleLancamento = listaControleLancamento;
		this.indice = indice;
		this.tamanhoPagina = tamanhoPagina;
		this.totalElements = totalElements;
	}

	public TotalControleLancamentoDTO getTotalControleLancamento() {
		return totalControleLancamento;
	}

	public void setTotalControleLancamento(TotalControleLancamentoDTO totalControleLancamento) {
		this.totalControleLancamento = totalControleLancamento;
	}

	public List<ControleLancamentoDTO> getListaControleLancamento() {
		return listaControleLancamento;
	}

	public void setListaControleLancamento(List<ControleLancamentoDTO> listaControleLancamento) {
		this.listaControleLancamento = listaControleLancamento;
	}

	public Integer getIndice() {
		return indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	public Integer getTamanhoPagina() {
		return tamanhoPagina;
	}

	public void setTamanhoPagina(Integer tamanhoPagina) {
		this.tamanhoPagina = tamanhoPagina;
	}

	public Integer getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Integer totalElements) {
		this.totalElements = totalElements;
	}

}
