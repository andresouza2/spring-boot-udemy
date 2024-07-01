package com.projectspring.aula.application.usecases.cliente.find;

import com.projectspring.aula.domain.entities.Cliente;
import com.projectspring.aula.application.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FindAllClienteUseCase {

    @Autowired
    private ClienteService clienteService;

    public FindAllClienteUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<Cliente> execute() {
        return clienteService.findAllCliente();
    }
}
