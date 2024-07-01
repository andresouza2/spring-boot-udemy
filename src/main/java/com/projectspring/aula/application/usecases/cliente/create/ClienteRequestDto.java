package com.projectspring.aula.application.usecases.cliente.create;

import com.projectspring.aula.domain.entities.Cliente;
import com.projectspring.aula.domain.entities.Pedido;

import java.util.Set;

public record ClienteRequestDto(String nome) {
    public static ClienteRequestDto from(Cliente cliente) {
        return  new ClienteRequestDto(cliente.getNome());
    }
}
