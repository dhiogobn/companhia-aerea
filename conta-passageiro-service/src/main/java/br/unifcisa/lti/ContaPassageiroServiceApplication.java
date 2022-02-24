package br.unifcisa.lti;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.unifcisa.lti.model.Conta;
import br.unifcisa.lti.repository.ContaPassageiroRepository;

@SpringBootApplication
public class ContaPassageiroServiceApplication implements CommandLineRunner{

	@Autowired
	private ContaPassageiroRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(ContaPassageiroServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Conta("dhiogobn", "1234", "dhiogo bandeira", new Date()));
		
	}
	
	

}
