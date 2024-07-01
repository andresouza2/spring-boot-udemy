package com.projectspring.aula.application.usecases.cliente.create;

import com.projectspring.aula.application.exceptions.ClienteExistsException;
import com.projectspring.aula.application.service.ClienteService;
import com.projectspring.aula.domain.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarUseCase {

    @Autowired
    private final ClienteService clienteService;

    public CadastrarUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Cliente execute(Cliente cliente) throws ClienteExistsException {
        String nome = cliente.getNome();
        var result = clienteService.findByNomeLike(nome);
        if(!result.isEmpty()) {
            throw new ClienteExistsException("Cliente já existe");
        }
        return clienteService.save(cliente);
    }
}
