package br.unifcisa.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unifcisa.lti.model.Conta;
import br.unifcisa.lti.service.ContaService;

@RestController
@RequestMapping("/conta-service")
public class ContaPassageiroController {

	@Autowired
	private ContaService service;
	
	@PostMapping
	public ResponseEntity<Conta> cadastrarConta(@RequestBody Conta conta){
		service.cadastrarConta(conta);
		return new ResponseEntity<Conta>(conta, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Conta> listarConta(){
		return service.listarContas();
	}
	@GetMapping("/{id}")
	public Conta getContaById(@PathVariable long id) {
		return service.getContaPassageiroById(id);
	}
	
	@PutMapping
	public Conta editarConta(@RequestBody Conta conta,@PathVariable long id) {
		return service.attConta(conta, id);
	}
	
	@DeleteMapping("/{id}")
	public Conta deletarConta(@PathVariable long id) {
		Conta conta = service.getContaPassageiroById(id);
		service.deletarContaById(id);
		return conta;
	}
	
	
	
	
	
}
