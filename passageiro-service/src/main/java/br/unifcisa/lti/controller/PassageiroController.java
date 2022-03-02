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

import br.unifcisa.lti.model.Passageiro;
import br.unifcisa.lti.service.PassageiroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "EndPoints de passageiro")
@RestController
@RequestMapping("/passageiro-service")
public class PassageiroController {
	
	@Autowired
	private PassageiroService service;
	
	@Operation(summary = "Cadastra um passageiro")
	@PostMapping
	public ResponseEntity<Passageiro> addPassageiro(Passageiro passageiro) {
		service.addPassageiro(passageiro);
		return new ResponseEntity<Passageiro>(passageiro, HttpStatus.CREATED);
	}
	
	@Operation(summary = "Lista os passageiros")
	@GetMapping
	public List<Passageiro> listarPassageiros() {
		return service.listarPassageiros();
	}
	
	@Operation(summary = "Localiza um passageiro pelo id")
	@GetMapping("/{id}")
	public Passageiro getPassageiroById(@PathVariable long id) {
		return service.getPassageiroById(id);
	}
	
	@Operation(summary = "Atualiza dados do passageiro")
	@PutMapping
	public Passageiro listarPassageiros(@RequestBody Passageiro passageiro, @PathVariable long id) {
		return service.attPassageiro(passageiro, id);
	}
	
	@Operation(summary = "Remove um passageiro")
	@DeleteMapping("/{id}")
	public Passageiro deletePassageiroById(@PathVariable long id) {
		return service.deletePassageiroById(id);
	}
	
	
	
}
