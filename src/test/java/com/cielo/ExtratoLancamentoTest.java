package com.cielo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cielo.dto.ExtratoLancamentoView;
import com.cielo.service.ExtratoLancamentoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExtratoLancamentoTest {

	@Autowired
	private ExtratoLancamentoService extratoLancamentoService;
	
	@Test
	public void testObterExtratoLancamento() {
		//InputStream inputStream = getClass().getResourceAsStream("/json/lancamento-conta-legado.json");
		//ExtratoLancamentoDTO extrato = extratoLancamentoService.importarExtratosLancamentos(inputStream);
		List<ExtratoLancamentoView> extratos = extratoLancamentoService.listarExtratosLancamentos();
		assertThat(extratos).isNotNull();
		assertThat(extratos.size()).isEqualTo(2);
	}
}
