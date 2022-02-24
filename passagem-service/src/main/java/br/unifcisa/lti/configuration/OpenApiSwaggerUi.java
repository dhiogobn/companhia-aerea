package br.unifcisa.lti.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(info = 
@Info(title = "Passagem Service Api", 
		version = "v1", 
		description = "Documentação swagger de Passagem Service API"))
public class OpenApiSwaggerUi {
	
	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI().components(new Components()).info( new io.swagger.v3.oas.models.info.Info()
				.title("Passagem Service API")
				.version("v1")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

		
	
}
