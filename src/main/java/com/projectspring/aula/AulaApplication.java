package com.projectspring.aula;

import com.projectspring.aula.domain.entity.Cliente;
import com.projectspring.aula.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AulaApplication {

	@Bean
	public CommandLineRunner init(@Autowired ClienteRepository clienteRepository) {
		return args -> {
			clienteRepository.save(new Cliente("André"));
			clienteRepository.save(new Cliente("Dayane"));
			clienteRepository.save(new Cliente("Kallel"));

			boolean existe = clienteRepository.existsByNome("André");
			System.out.println("existe um cliente com esse nome: " + existe);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

}
