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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "EndPoints de Conta passageiro")
@RestController
@RequestMapping("/conta-service")
public class ContaPassageiroController {

	@Autowired
	private ContaService service;
	
	@Operation(summary = "Cadastra uma conta para o passageiro")
	@PostMapping
	public ResponseEntity<Conta> cadastrarConta(@RequestBody Conta conta){
		service.cadastrarConta(conta);
		return new ResponseEntity<Conta>(conta, HttpStatus.CREATED);
	}
	
	@Operation(summary = "Lista todas as contas de todos os passageiros")
	@GetMapping
	public List<Conta> listarConta(){
		return service.listarContas();
	}
	
	@Operation(summary = "Localiza um passageiro pelo id")
	@GetMapping("/{id}")
	public Conta getContaById(@PathVariable long id) {
		return service.getContaPassageiroById(id);
	}
	
	@Operation(summary = "Atualiza os dados da conta do passageiro")
	@PutMapping
	public Conta editarConta(@RequestBody Conta conta,@PathVariable long id) {
		return service.attConta(conta, id);
	}
	
	@Operation(summary = "Deleta a conta de um passageiro pelo id")
	@DeleteMapping("/{id}")
	public Conta deletarConta(@PathVariable long id) {
		Conta conta = service.getContaPassageiroById(id);
		service.deletarContaById(id);
		return conta;
	}
	
	
	
	
	
}
