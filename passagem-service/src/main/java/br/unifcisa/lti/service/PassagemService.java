package br.unifcisa.lti.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unifcisa.lti.model.Passagem;
import br.unifcisa.lti.proxy.ContaPassageiroProxy;
import br.unifcisa.lti.proxy.PassageiroProxy;
import br.unifcisa.lti.repository.PassagemRepository;
import br.unifcisa.lti.response.Conta;
import br.unifcisa.lti.response.Passageiro;

@Service
public class PassagemService {
	
	@Autowired
	private PassagemRepository repository;
	
	@Autowired
	private ContaPassageiroProxy contaProxy;
	
	@Autowired
	private PassageiroProxy passageiroProxy;
	
	public Passagem comprarPassagem(double valor, long idPassageiro,long idConta) {
		Conta conta = contaProxy.getContaById(idConta);
		Passageiro passageiro = passageiroProxy.getPassageiroById(idPassageiro);
		Calendar dataDeAgora = Calendar.getInstance();
		Calendar dataDeEmbarque = Calendar.getInstance();
		dataDeEmbarque.set(Calendar.YEAR, 2022);
		dataDeEmbarque.set(Calendar.MONTH, 3);
		dataDeEmbarque.set(Calendar.DAY_OF_MONTH, dataDeAgora.get(Calendar.DAY_OF_MONTH)+1);
		return repository.save(new Passagem(conta.getLogin(), passageiro.getCpf(),dataDeAgora.getTime(), dataDeEmbarque.getTime(), valor));
		
	}
	
	public List<Passagem> historicoDeCompras(){
		return repository.findAll();
	}

}
