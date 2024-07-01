package com.projectspring.aula.infra.repositories;

import com.projectspring.aula.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = " select * from cliente c where c.nome ilike %:nome% ", nativeQuery = true)
    List<Cliente> findByNomeLike(@Param("nome") String nome);

    Optional<Cliente> findByNome(String nome);

    @Query(" DELETE FROM Cliente c WHERE c.nome = :nome ")
    @Modifying
    @Transactional
    void deleteEntityByNome(String nome);

    boolean existsByNome(String nome);

    @Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id ")
    Cliente findClienteFetchPedidos(@Param("id") Integer id );
}
