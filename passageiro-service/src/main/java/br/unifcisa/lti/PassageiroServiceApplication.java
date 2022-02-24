package br.unifcisa.lti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.unifcisa.lti.model.Passageiro;
import br.unifcisa.lti.repository.PassageiroRepository;

@SpringBootApplication
public class PassageiroServiceApplication implements CommandLineRunner {

	@Autowired
	private PassageiroRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(PassageiroServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		repository.save(new Passageiro("dhiogo bandeira", "21098309128", "Rua joão pessoa, 22", "4002-8922"));
	}

}
