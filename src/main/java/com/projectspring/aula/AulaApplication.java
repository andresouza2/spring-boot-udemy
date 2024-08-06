package com.projectspring.aula;

import com.projectspring.aula.domain.entity.Cliente;
import com.projectspring.aula.domain.entity.Pedido;
import com.projectspring.aula.domain.repository.ClienteRepository;
import com.projectspring.aula.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class AulaApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired ClienteRepository clienteRepository,
			@Autowired PedidoRepository pedidoRepository
	) {
		return args -> {
			System.out.println("Salvando clientes");
			Cliente andre = new Cliente("André");
			clienteRepository.save(andre);

			Cliente kallel = new Cliente("Kallel Braga Gomes de Souza");
			clienteRepository.save(kallel);

			Pedido p = new Pedido();
			p.setCliente(andre);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100));

			pedidoRepository.save(p);

//			Cliente cliente = clienteRepository.findClienteFetchPedidos(andre.getId());
//			System.out.println(cliente);
//			System.out.println(cliente.getPedidos());

			if(!pedidoRepository.findByCliente(andre).isEmpty()) {
				pedidoRepository.findByCliente(andre).forEach(System.out::println);
			}else {
				System.out.println("Pedidos nao encontrados");
			}

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

}
