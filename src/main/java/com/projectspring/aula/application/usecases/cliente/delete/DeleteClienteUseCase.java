package com.projectspring.aula.application.usecases.cliente.delete;

import com.projectspring.aula.application.service.ClienteService;
import com.projectspring.aula.domain.entities.Cliente;

public class DeleteClienteUseCase {

    private ClienteService clienteService;

    public DeleteClienteUseCase(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void execute(Cliente cliente) {
        clienteService.deleteByCliente(cliente);
    }

}
