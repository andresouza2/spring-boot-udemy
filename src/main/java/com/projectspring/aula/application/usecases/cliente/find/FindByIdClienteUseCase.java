package com.projectspring.aula.application.usecases.cliente.find;

import com.projectspring.aula.application.service.ClienteService;
import com.projectspring.aula.domain.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class FindByIdClienteUseCase {

    @Autowired
    private ClienteService clienteService;

    public FindByIdClienteUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Optional<Cliente> execute(Integer id) {
        return clienteService.findById(id);
    }
}
