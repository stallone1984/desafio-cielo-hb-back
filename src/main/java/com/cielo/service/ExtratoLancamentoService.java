package com.cielo.service;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.cielo.dto.ControleLancamentoDTO;
import com.cielo.dto.ExtratoLancamentoDTO;
import com.cielo.dto.ExtratoLancamentoView;
import com.cielo.exception.DadoObrigatorioException;
import com.cielo.exception.LeituraDadosExtratoException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ExtratoLancamentoService {
	
	private static final Logger log = LoggerFactory.getLogger(ExtratoLancamentoService.class);

	public List<ExtratoLancamentoView> listarExtratosLancamentos(){
		try {
			ExtratoLancamentoDTO lancamento = obterExtratoLancamento();
			validarExtraLancamento(lancamento);
			return montarExtratoLancamentoView(lancamento);
		} catch (DadoObrigatorioException doe){
			log.error("Erro ao importar os dados: {}", doe.getMessage());
			throw new DadoObrigatorioException(doe.getMessage());
		} catch (LeituraDadosExtratoException lde){
			log.error("Erro ao importar os dados: {}", lde.getMessage());
			throw new LeituraDadosExtratoException("Não foi possível processar os dados do seu extrato de lançamentos.");
		}
	}
	
	public ExtratoLancamentoDTO obterExtratoLancamento() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<ExtratoLancamentoDTO> typeReference = new TypeReference<ExtratoLancamentoDTO>(){};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/lancamento-conta-legado.json");
		try {
			ExtratoLancamentoDTO lancamento = mapper.readValue(inputStream, typeReference);
			log.info("Dados importados com sucesso");
			return lancamento;
		} catch (Exception e){
			log.error("Erro ao importar os dados: {}", e.getMessage());
			throw new LeituraDadosExtratoException(e.getMessage());
		}
	}
	
	public void validarExtraLancamento(ExtratoLancamentoDTO extratoLancamento) {
		if(CollectionUtils.isEmpty(extratoLancamento.getListaControleLancamento())) {
			return;
		}
		
		for(ControleLancamentoDTO controleLancamento : extratoLancamento.getListaControleLancamento()) {
			if(controleLancamento.getDataLancamentoContaCorrenteCliente() == null) {
				throw new DadoObrigatorioException("Existe um ou mais lançamentos sem a data de lançamento informada");
			}
			
			if(controleLancamento.getLancamentoContaCorrenteCliente() == null) {
				throw new DadoObrigatorioException("Existe um ou mais lançamentos sem o lançamento na conta corrente do cliente");
			}
			
			if(controleLancamento.getLancamentoContaCorrenteCliente().getNumeroRemessaBanco() == null 
					|| controleLancamento.getLancamentoContaCorrenteCliente().getNumeroRemessaBanco().equals(0L)) {
				throw new DadoObrigatorioException("Existe um ou mais lançamentos sem o número de remessa do banco");
			}
			
			if(controleLancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario() == null) {
				throw new DadoObrigatorioException("Existe um ou mais lançamentos sem os dados bancários definidos");
			}
			
			if(controleLancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getCodigoBanco() == null) {
				throw new DadoObrigatorioException("Existe um ou mais lançamentos sem o código do banco definido");
			}
			
			if(controleLancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroAgencia() == null) {
				throw new DadoObrigatorioException("Existe um ou mais lançamentos sem o número da agência definido");
			}
			
			if(StringUtils.isEmpty(controleLancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroContaCorrente())) {
				throw new DadoObrigatorioException("Existe um ou mais lançamentos sem o número da conta corrente definido");
			}
			
			if(controleLancamento.getValorLancamentoRemessa() == null || controleLancamento.getValorLancamentoRemessa().equals(BigDecimal.ZERO)) {
				throw new DadoObrigatorioException("Existe um ou mais lançamentos sem o valor final definido");
			}
		}
	}

	public List<ExtratoLancamentoView> montarExtratoLancamentoView(ExtratoLancamentoDTO extratoLancamentoDTO) {
		List<ExtratoLancamentoView> extratos = new ArrayList<>();
		
		if(CollectionUtils.isEmpty(extratoLancamentoDTO.getListaControleLancamento())) {
			return extratos;
		}
		
		for(ControleLancamentoDTO lancamento : extratoLancamentoDTO.getListaControleLancamento()) {
			ExtratoLancamentoView extratoLancamentoView = new ExtratoLancamentoView();
			extratoLancamentoView.setDataLancamento(lancamento.getDataLancamentoContaCorrenteCliente());
			extratoLancamentoView.setDataConfirmacao(lancamento.getDataEfetivaLancamento());
			extratoLancamentoView.setDescricao(lancamento.getLancamentoContaCorrenteCliente().getNomeTipoOperacao());
			extratoLancamentoView.setSituacao(lancamento.getLancamentoContaCorrenteCliente().getNomeSituacaoRemessa());
			extratoLancamentoView.setNumero(lancamento.getLancamentoContaCorrenteCliente().getNumeroRemessaBanco());
			extratoLancamentoView.setValorFinal(lancamento.getValorLancamentoRemessa());
			extratoLancamentoView.setDadosBancarios(obterDadosBancarios(lancamento));
			extratos.add(extratoLancamentoView);
		}
		
		return extratos;
	}

	public String obterDadosBancarios(ControleLancamentoDTO lancamento) {
		StringBuilder dadosBancarios = new StringBuilder();
		dadosBancarios.append(lancamento.getNomeBanco());
		dadosBancarios.append(" Ag " + lancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroAgencia());
		dadosBancarios.append(" CC " + lancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroContaCorrente());
		
		return dadosBancarios.toString();
	}
}
