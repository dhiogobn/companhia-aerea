package br.unifcisa.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unifcisa.lti.model.Conta;
import br.unifcisa.lti.repository.ContaPassageiroRepository;

@Service
public class ContaService {

	@Autowired
	private ContaPassageiroRepository repository;
	
	public void cadastrarConta(Conta conta) {
		repository.save(conta);
	}
	
	public List<Conta> listarContas(){
		return repository.findAll();
	}
	
	public Conta getContaPassageiroById(long id){
		return repository.findById(id).get();
	}
	
	public Conta attConta(Conta contaAtt, long id) {
		Conta conta = repository.findById(id).get();
		conta.setSenha(contaAtt.getSenha());
		repository.save(conta);
		return conta;
		
	}
	
	public void deletarContaById(long id) {
		repository.deleteById(id);
	}
	
	
}
