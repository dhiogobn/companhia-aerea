package br.unifcisa.lti.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Passagem EndPoints")
@RestController
@RequestMapping("/passagem-service")
public class FooBarController {

	private static final String SERVIDOR_CAÍDO_TENTE_NOVAMENTE_MAIS_TARDE = "Servidor caído tente novamente mais tarde";
	private Logger logger = LoggerFactory.getLogger(FooBarController.class);
	
	//@CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
	@Retry(name = "default", fallbackMethod = "fallbackMethod")
	@GetMapping("/foo-bar")	
	private String fooBar() {
		//logger.info("tentando conectar ao end point");
		var response =  new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
		//this.logger.info(response.getBody());
		//return "foo-bar!!";
		return response.getBody();
	}
	
	public String fallbackMethod(Exception ex) {
		return SERVIDOR_CAÍDO_TENTE_NOVAMENTE_MAIS_TARDE;
	}
	
}
