package br.unifcisa.lti.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.unifcisa.lti.response.Passageiro;


@FeignClient(name = "passageiro-service", url = "localhost:8000/passageiro-service")
public interface PassageiroProxy {

	@GetMapping("/{id}")
	public Passageiro getPassageiroById(@PathVariable long id);
}
