package com.projectspring.aula.infra.repositories;

import com.projectspring.aula.domain.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
