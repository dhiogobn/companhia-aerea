package br.unifcisa.lti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PassagemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassagemServiceApplication.class, args);
	}

}
