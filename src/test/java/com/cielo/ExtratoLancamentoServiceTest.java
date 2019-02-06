package com.cielo;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cielo.dto.ControleLancamentoDTO;
import com.cielo.dto.ExtratoLancamentoDTO;
import com.cielo.dto.ExtratoLancamentoView;
import com.cielo.exception.DadoObrigatorioException;
import com.cielo.service.ExtratoLancamentoService;

/**
 * Classe de testes para o serviço {@link ExtratoLancamentoService}
 * 
 * @author heitor bernardino
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtratoLancamentoServiceTest {

	@Autowired
	private ExtratoLancamentoService extratoLancamentoService;
	
	private static final Long NUMERO_PRIMEIRO_LANCAMENTO = 64320236054L;
	private static final BigDecimal VALOR_FINAL_PRIMEIRO_LANCAMENTO = new BigDecimal("11499.1");
	private static final LocalDate DATA_PRIMEIRO_LANCAMENTO = LocalDate.of(2016, 6, 3);
	private static final String NOME_BANCO_PRIMEIRO_LANCAMENTO = "BANCO ABCD S.A.";
	
	private static final Long NUMERO_SEGUNDO_LANCAMENTO = 64320626054L;
	private static final BigDecimal VALOR_FINAL_SEGUNDO_LANCAMENTO = new BigDecimal("1960");
	private static final LocalDate DATA_SEGUNDO_LANCAMENTO = LocalDate.of(2016, 6, 2);
	private static final String NUMERO_CONTA_CORRENTE_SEGUNDO_LANCAMENTO = "00000000065470";
	private static final Integer NUMERO_AGENCIA_SEGUNDO_LANCAMENTO = 1;
	private static final String NOME_BANCO_SEGUNDO_LANCAMENTO = "BANCO ABCD S.A.";
	
	
	/**
	 * Testa o retorno do método {@link ExtratoLancamentoService#listarExtratosLancamentos()}
	 */
	@Test
	public void testListarExtratosLancamentosView() {
		List<ExtratoLancamentoView> lancamentos = extratoLancamentoService.listarExtratosLancamentos();
		
		assertThat(lancamentos).isNotNull();
		assertThat(lancamentos.size()).isEqualTo(2);
		
		ExtratoLancamentoView primeiroLancamento = lancamentos.get(0);
		assertThat(primeiroLancamento.getNumero()).isEqualTo(NUMERO_PRIMEIRO_LANCAMENTO);
		assertThat(primeiroLancamento.getValorFinal().compareTo(VALOR_FINAL_PRIMEIRO_LANCAMENTO)).isEqualTo(0);
		assertThat(primeiroLancamento.getDataLancamento()).isEqualTo(DATA_PRIMEIRO_LANCAMENTO);
		assertThat(primeiroLancamento.getDadosBancarios()).contains(NOME_BANCO_PRIMEIRO_LANCAMENTO);
	}
	
	/**
	 * Testa o retorno do método {@link ExtratoLancamentoService#obterExtratoLancamento())}
	 */
	@Test
	public void testObterExtratoLancamentoDTO() {
		ExtratoLancamentoDTO lancamento = extratoLancamentoService.obterExtratoLancamento();
		
		assertThat(lancamento).isNotNull();
		assertThat(lancamento.getListaControleLancamento().size()).isEqualTo(2);
		
		ControleLancamentoDTO segundoLancamento = lancamento.getListaControleLancamento().get(1);
		
		assertThat(segundoLancamento.getLancamentoContaCorrenteCliente().getNumeroRemessaBanco()).isEqualTo(NUMERO_SEGUNDO_LANCAMENTO);
		assertThat(segundoLancamento.getValorLancamentoRemessa().compareTo(VALOR_FINAL_SEGUNDO_LANCAMENTO)).isEqualTo(0);
		assertThat(segundoLancamento.getDataLancamentoContaCorrenteCliente()).isEqualTo(DATA_SEGUNDO_LANCAMENTO);
		assertThat(segundoLancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroContaCorrente()).isEqualTo(NUMERO_CONTA_CORRENTE_SEGUNDO_LANCAMENTO);
		assertThat(segundoLancamento.getLancamentoContaCorrenteCliente().getDadosDomicilioBancario().getNumeroAgencia()).isEqualTo(NUMERO_AGENCIA_SEGUNDO_LANCAMENTO);
		assertThat(segundoLancamento.getNomeBanco()).isEqualTo(NOME_BANCO_SEGUNDO_LANCAMENTO);
	}
	
	
	/**
	 * Gera uma exceção {@link DadoObrigatorioException} pois o atributo 
	 * {@link ControleLancamentoDTO#getDataLancamentoContaCorrenteCliente()} é nulo
	 */
	@Test(expected=DadoObrigatorioException.class)
	public void testDadoObrigatorioException() {
		ControleLancamentoDTO controleLancamento = new ControleLancamentoDTO();
		
		ExtratoLancamentoDTO extratoLancamento = new ExtratoLancamentoDTO();
		extratoLancamento.setListaControleLancamento(new ArrayList<ControleLancamentoDTO>());
		extratoLancamento.getListaControleLancamento().add(controleLancamento);
		
		extratoLancamentoService.validarExtraLancamento(extratoLancamento);
	}
	
}
