package br.unifcisa.lti.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.unifcisa.lti.Exception.BusinessException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

//@Tag(name = "Passagem EndPoints")
@RestController
@RequestMapping("/passagem-service")
public class FooBarController {

	private static final String SERVIDOR_CAÍDO_TENTE_NOVAMENTE_MAIS_TARDE = "Servidor caído tente novamente mais tarde";
	private final static Logger logger = LoggerFactory.getLogger(FooBarController.class);
	
	@CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
	@GetMapping("/foo-bar")	
	private String fooBar() {
		logger.info("tentando conectar ao end point");
		var response =  new RestTemplate().getForEntity("http://localhost:8100/conta-service/blabla", String.class);
		logger.info(response.getBody());
		return response.getBody();
		//return "foo-bar!!";
	}
	
	public String fallbackMethod(BusinessException ex) {
		return SERVIDOR_CAÍDO_TENTE_NOVAMENTE_MAIS_TARDE;
	}
	
}
