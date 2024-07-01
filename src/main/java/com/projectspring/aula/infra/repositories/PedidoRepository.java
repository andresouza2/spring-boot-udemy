package com.projectspring.aula.infra.repositories;

import com.projectspring.aula.domain.entities.Cliente;
import com.projectspring.aula.domain.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByCliente(Cliente cliente);
}
