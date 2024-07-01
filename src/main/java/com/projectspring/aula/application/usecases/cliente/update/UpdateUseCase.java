package com.projectspring.aula.application.usecases.cliente.update;

import com.projectspring.aula.application.service.ClienteService;
import com.projectspring.aula.application.usecases.cliente.create.ClienteRequestDto;
import com.projectspring.aula.domain.entities.Cliente;

public class UpdateUseCase {

    private ClienteService clienteService;

    public UpdateUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Cliente execute(Cliente cliente) {
        return clienteService.save(cliente);
    }

}
