package br.unifcisa.lti.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.unifcisa.lti.model.Passagem;
import br.unifcisa.lti.service.PassagemService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Passagem EndPoints")
@RestController
@RequestMapping("/passagem-service")
public class PassagemController {

	private Logger logger = LoggerFactory.getLogger(PassagemController.class);
	private static final String SERVIDOR_CAÍDO_TENTE_NOVAMENTE_MAIS_TARDE = "Servidor caído tente novamente mais tarde";
	@Autowired
	private PassagemService service;
	
	@Retry(name = "default")
	@Operation(summary = "Realiza compra de passagens")
	@GetMapping("{valor}/{idPassageiro}/{idConta}")
	public Passagem comprarPassagem(@PathVariable double valor,@PathVariable long idPassageiro,@PathVariable long idConta) {
		return service.comprarPassagem(valor, idPassageiro, idConta);
	}
	

	@Operation(summary = "Lista todas as compras realizadas no aero porto")
	@GetMapping
	public List<Passagem> historicoDeCompras(){
		return service.historicoDeCompras();
	}
	
}
	

