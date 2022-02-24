package br.com.unifacisa.lti.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifacisa.lti.exception.SaldoInsuficienteException;
import br.com.unifacisa.lti.model.Conta;
import br.com.unifacisa.lti.service.ContaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Conta endPoint")
@RestController
@RequestMapping("conta-service")
public class ContaController {

	private static final String STRING_VAZIA = "";
	@Autowired
	private ContaService service;
	
	@Operation(summary = "Listar todas as contas do banco")
	@GetMapping
	public ResponseEntity<List<Conta>> listarContas(){
		return ResponseEntity.ok(service.listarConstas());
	}
	
	@Operation(summary = "Obter conta por id")
	@GetMapping("/{id}")
	public ResponseEntity<Conta> getContaById(@PathVariable long id){
		return ResponseEntity.ok(service.getContaById(id));
	}
	@Operation(summary = "Criar conta no banco")
	@PostMapping
	public ResponseEntity<Conta> cadastrarConta(@RequestBody Conta conta){
		service.cadastrarConta(conta);
		return new ResponseEntity<Conta>(conta, HttpStatus.CREATED);
	}
	
	@Operation(summary = "Atualizar conta existente do banco")
	@PutMapping("/{id}")
	public ResponseEntity<Conta> updateConta(@RequestBody Conta conta, @PathVariable long id){
		return ResponseEntity.ok(service.updateConta(conta, id));
	}
	
	@Operation(summary = "Depositar um valor em conta")
	@GetMapping("/depositar/{valor}/{id}")
	public ResponseEntity<String> depositar(@PathVariable double valor, @PathVariable long id){
		return ResponseEntity.ok(service.depositar(valor, id));
	}
	
	@Operation(summary = "Sacar um valor em conta")
	@GetMapping("/sacar/{valor}/{id}")
	public ResponseEntity<String> sacar(@PathVariable double valor, @PathVariable long id){
		String saldo= STRING_VAZIA;
		try {
			saldo = service.sacar(valor, id);
		} catch (SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok(saldo);
	}
	
	@Operation(summary = "Transferir um valor de uma conta A para uma conta B")
	@GetMapping("/transferir/{valor}/{id1}/{id2}")
	public Conta transferir(@PathVariable double valor, @PathVariable long id1, @PathVariable long id2){
		Conta contaTransferida = null;
		try {
			contaTransferida = service.trasnferir(id1, id2, valor);
		} catch (SaldoInsuficienteException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return contaTransferida;
	}
	
}
