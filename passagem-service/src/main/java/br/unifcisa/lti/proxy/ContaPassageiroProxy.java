package br.unifcisa.lti.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.unifcisa.lti.response.Conta;


@FeignClient(name = "conta-service", url = "localhost:8100/conta-service")
public interface ContaPassageiroProxy {

	@GetMapping("/{id}")
	public Conta getContaById(@PathVariable long id);
	
}
