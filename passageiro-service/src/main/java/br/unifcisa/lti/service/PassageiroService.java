package br.unifcisa.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unifcisa.lti.model.Passageiro;
import br.unifcisa.lti.repository.PassageiroRepository;

@Service
public class PassageiroService {

	@Autowired
	private PassageiroRepository repository;
	
	public void addPassageiro(Passageiro passageiro) {
		repository.save(passageiro);
	}
	
	public List<Passageiro> listarPassageiros() {
		return repository.findAll();
	}
	
	public Passageiro getPassageiroById(long id) {
		return repository.findById(id).get();
	}
	
	public Passageiro attPassageiro(Passageiro passageiroAtt, long id) {
		Passageiro passageiro = repository.findById(id).get();
		passageiro.setTelefone(passageiroAtt.getTelefone());
		passageiro.setEndereco(passageiroAtt.getEndereco());
		repository.save(passageiro);
		return passageiro;
	}
	
	public Passageiro deletePassageiroById(long id) {
		Passageiro passageiro = repository.findById(id).get();
		repository.deleteById(id);
		return passageiro;
	}

}
