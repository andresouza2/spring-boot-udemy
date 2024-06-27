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

			List<Cliente> clientesList = clienteRepository.findAll();
			clientesList.forEach(System.out::println);

			clientesList.forEach(cliente -> {
				cliente.setNome(cliente.getNome() + " atualizado");
				clienteRepository.update(cliente);
			});

//			System.out.println("Buscando clientes");
//				clienteRepository.findByName("Andr").forEach(System.out::println);

//			System.out.println("deletando clientes");
//			clienteRepository.findAll().forEach(clienteRepository::deletar);

			clientesList = clienteRepository.findAll();
			if(clientesList.isEmpty()) {
				System.out.println("|---------------- nenhum cliente encontrado -------------|");
			}else {
				clientesList.forEach(System.out::println);
			}

			clientesList = clienteRepository.findAll();

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

}
