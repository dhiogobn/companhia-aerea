package br.unifcisa.lti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerCompanhiaAereaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerCompanhiaAereaApplication.class, args);
	}

}
