package br.com.unifacisa.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacisa.lti.exception.SaldoInsuficienteException;
import br.com.unifacisa.lti.model.Conta;
import br.com.unifacisa.lti.repository.ContaRepository;

@Service
public class ContaService {
	
	private static final String TRANSFERÊNCIA_REALIZADA_COM_SUCESSO = "Transferência realizada com sucesso!!";
	private static final String DEPOSITO_REALIZADO_COM_SUCESSO = "Deposito realizado com sucesso";
	private static final String SAQUE_REALIZADO_COM_SUCESSO = "Saque realizado com sucesso!";
	
	@Autowired
	private ContaRepository repository;

	public void cadastrarConta(Conta conta){
		repository.save(conta);
	}
	
	public List<Conta> listarConstas(){
		List<Conta> contas = repository.findAll();
		return contas;
	}
	
	public Conta getContaById(long id) {
		Conta conta = repository.findById(id).get();
		return conta;
	}
	
	public void removerConta(long id) {
		repository.deleteById(id);
	}
	
	public Conta updateConta(Conta contaAtualizada, long id) {
		Conta conta = repository.findById(id).get();
		conta.setAgencia(contaAtualizada.getAgencia());
		conta.setConta(contaAtualizada.getConta());
		conta.setTitular(contaAtualizada.getTitular());
		repository.save(conta);
		return conta;
	}
	
	public String depositar(double valor, long id) {
		Conta conta = repository.findById(id).get();
		conta.setSaldo(conta.getSaldo()+valor);
		repository.save(conta);
		return DEPOSITO_REALIZADO_COM_SUCESSO;
		
	}

	public String sacar(double valor, long id) throws SaldoInsuficienteException {
		Conta conta = repository.findById(id).get();
		if(valor> conta.getSaldo()) {
			throw new SaldoInsuficienteException();
		}
		conta.setSaldo(conta.getSaldo()-valor);
		repository.save(conta);
		return SAQUE_REALIZADO_COM_SUCESSO;
	}
	
	public Conta trasnferir(long idTransferidora, long idTransferida,double valor) throws SaldoInsuficienteException {
		Conta contaTransferidora = repository.findById(idTransferidora).get();
		Conta contaTransferida = repository.findById(idTransferida).get();
		if(contaTransferidora.getSaldo()< valor) {
			throw new SaldoInsuficienteException();
		}
		contaTransferidora.setSaldo(contaTransferidora.getSaldo()-valor);
		contaTransferida.setSaldo(contaTransferida.getSaldo()+valor);
		repository.save(contaTransferida);
		repository.save(contaTransferidora);
		return contaTransferida;
	}
}
