package com.cielo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cielo.controller.ExtratoLancamentoController;
import com.cielo.dto.ExtratoLancamentoView;
import com.cielo.service.ExtratoLancamentoService;

/**
 * Classe de teste para o controller {@link ExtratoLancamentoController}
 * 
 * @author heitor bernardino
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtratoLancamentoControllerTest {

	@Autowired
	private ExtratoLancamentoController extratoLancamentoController;
	
	@MockBean
	private ExtratoLancamentoService extratoLancamentoServiceMock;
	
	private List<ExtratoLancamentoView> lancamentos = new ArrayList<ExtratoLancamentoView>();
	
	private static final Long NUMERO_PRIMEIRO_LANCAMENTO = 64320236054L;
	private static final BigDecimal VALOR_FINAL_PRIMEIRO_LANCAMENTO = new BigDecimal("11499.1");
	private static final LocalDate DATA_PRIMEIRO_LANCAMENTO = LocalDate.of(2016, 6, 3);
	
	private static final Long NUMERO_SEGUNDO_LANCAMENTO = 64320626054L;
	private static final BigDecimal VALOR_FINAL_SEGUNDO_LANCAMENTO = new BigDecimal("1960");
	private static final LocalDate DATA_SEGUNDO_LANCAMENTO = LocalDate.of(2016, 6, 2);
	
	@Before
	public void setUp() {
		popularLancamentosMock();
	}
	
	/**
	 * Testa o endpoint {@link ExtratoLancamentoController#importarExtratosLancamentos()}
	 * mockando a instância do serviço {@link ExtratoLancamentoService}
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testExtratoLancamentoController() {
		when(extratoLancamentoServiceMock.listarExtratosLancamentos()).thenReturn(lancamentos);
		List<ExtratoLancamentoView> lancamentosRetorno = (List<ExtratoLancamentoView>)extratoLancamentoController.importarExtratosLancamentos().getBody().getRetorno();
		assertThat(lancamentosRetorno.size()).isEqualTo(2);
		
		ExtratoLancamentoView primeiroLancamento = lancamentosRetorno.get(0);
		assertThat(primeiroLancamento.getNumero()).isEqualTo(NUMERO_PRIMEIRO_LANCAMENTO);
		assertThat(primeiroLancamento.getValorFinal().compareTo(VALOR_FINAL_PRIMEIRO_LANCAMENTO)).isEqualTo(0);
		assertThat(primeiroLancamento.getDataLancamento()).isEqualTo(DATA_PRIMEIRO_LANCAMENTO);
		
		ExtratoLancamentoView segundoLancamento = lancamentosRetorno.get(1);
		assertThat(segundoLancamento.getNumero()).isEqualTo(NUMERO_SEGUNDO_LANCAMENTO);
		assertThat(segundoLancamento.getValorFinal().compareTo(VALOR_FINAL_SEGUNDO_LANCAMENTO)).isEqualTo(0);
		assertThat(segundoLancamento.getDataLancamento()).isEqualTo(DATA_SEGUNDO_LANCAMENTO);
	}
	
	private void popularLancamentosMock() {
		ExtratoLancamentoView primeiroLancamento = new ExtratoLancamentoView();
		primeiroLancamento.setDataLancamento(DATA_PRIMEIRO_LANCAMENTO);
		primeiroLancamento.setNumero(NUMERO_PRIMEIRO_LANCAMENTO);
		primeiroLancamento.setValorFinal(VALOR_FINAL_PRIMEIRO_LANCAMENTO);
		
		lancamentos.add(primeiroLancamento);
		
		ExtratoLancamentoView segundoLancamento = new ExtratoLancamentoView();
		segundoLancamento.setDataLancamento(DATA_SEGUNDO_LANCAMENTO);
		segundoLancamento.setNumero(NUMERO_SEGUNDO_LANCAMENTO);
		segundoLancamento.setValorFinal(VALOR_FINAL_SEGUNDO_LANCAMENTO);
		
		lancamentos.add(segundoLancamento);
	}
	
}
