package com.cielo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cielo.dto.DadosRetornoApiDTO;
import com.cielo.dto.ExtratoLancamentoView;
import com.cielo.exception.DadoObrigatorioException;
import com.cielo.service.ExtratoLancamentoService;

@RestController
@RequestMapping("/extrato-lancamento")
public class ExtratoLancamentoController {

	@Autowired
	private ExtratoLancamentoService extratoLancamentoService;
	
	/*@PostMapping("/importar")
	public DadosRetornoApiDTO importarExtratosLancamentos(@RequestParam("file") MultipartFile file){
		try {
			ExtratoLancamentoDTO extrato = extratoLancamentoService.importarExtratosLancamentos(file.getInputStream());
			return new DadosRetornoApiDTO(true, "Dados importados com sucesso", extrato);
		} catch (Exception e) {
			return new DadosRetornoApiDTO(false, "Erro ao importar os dados", e.getMessage());
		}
	}*/
	
	@GetMapping("/listar")
	public ResponseEntity<DadosRetornoApiDTO> importarExtratosLancamentos(){
		try {
			List<ExtratoLancamentoView> extratos = extratoLancamentoService.listarExtratosLancamentos();
			return ResponseEntity.status(HttpStatus.OK).body(
					new DadosRetornoApiDTO(true, "Dados importados com sucesso", extratos));
		} catch (DadoObrigatorioException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new DadosRetornoApiDTO(false, "Erro ao importar os dados", e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
					new DadosRetornoApiDTO(false, "Erro ao importar os dados", e.getMessage()));
		}
	}
}
