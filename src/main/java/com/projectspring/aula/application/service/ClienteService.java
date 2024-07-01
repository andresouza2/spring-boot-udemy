package com.projectspring.aula.application.service;

import com.projectspring.aula.domain.entities.Cliente;
import com.projectspring.aula.application.usecases.cliente.create.ClienteRequestDto;
import com.projectspring.aula.infra.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente save(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    public List<Cliente> findAllCliente() {
        return this.clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Integer id) {
        return this.clienteRepository.findById(id);
    }

    public Optional<Cliente> findByName(String nome) {
        return this.clienteRepository.findByNome(nome);
    }

    public List<Cliente> findByNomeLike(String nome) {
        return clienteRepository.findByNomeLike(nome);
    }

    public void deleteByCliente(Cliente cliente) {
        clienteRepository.deleteById(cliente.getId());
    }

}
