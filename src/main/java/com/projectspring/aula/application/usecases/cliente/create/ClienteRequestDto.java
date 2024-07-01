package com.projectspring.aula.application.usecases.cliente.create;

import com.projectspring.aula.domain.entities.Cliente;
import jakarta.validation.constraints.NotBlank;


public record ClienteRequestDto(@NotBlank(message = "o campo não deve ser vazio ou nullo") String nome) {
    public static ClienteRequestDto from(Cliente cliente) {
        return  new ClienteRequestDto(cliente.getNome());
    }
}
