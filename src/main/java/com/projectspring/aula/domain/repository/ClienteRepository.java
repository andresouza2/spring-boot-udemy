package com.projectspring.aula.domain.repository;

import com.projectspring.aula.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeLike(String nome);

    List<Cliente> findByNomeOrIdOrderById(String nome, Long id);

    boolean existsByNome(String nome);
}
