package br.com.arfaxtec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication//identifica como uma aplicação spring
@EntityScan(basePackages = {"br.com.arfaxtec.apirest.model"})//ler todas as classes desse pacote
@ComponentScan(basePackages = {"br.com.arfaxtec.apirest.*"})
@EnableJpaRepositories(basePackages = {"br.com.arfaxtec.apirest.repository"})
@EnableTransactionManagement
@EnableWebMvc
@RestController
@EnableAutoConfiguration//o spring configura todo o projeto automaticamente
public class CursoSpringBootRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringBootRestApiApplication.class, args);
	}

}
