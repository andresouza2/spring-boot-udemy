package com.projectspring.aula.interfaceAdapters.controllers;

import static com.projectspring.aula.infra.utils.RestPath.*;

import com.projectspring.aula.application.usecases.cliente.delete.DeleteClienteUseCase;
import com.projectspring.aula.application.usecases.cliente.find.FindByIdClienteUseCase;
import com.projectspring.aula.application.usecases.cliente.update.UpdateUseCase;
import com.projectspring.aula.domain.entities.Cliente;
import com.projectspring.aula.application.usecases.cliente.create.CadastrarUseCase;
import com.projectspring.aula.application.usecases.cliente.create.ClienteRequestDto;
import com.projectspring.aula.application.usecases.cliente.find.FindAllClienteUseCase;
import com.projectspring.aula.application.service.ClienteService;
import com.projectspring.aula.interfaceAdapters.dto.ErrorDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = API + VERSION + CLIENTE)
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/create")
    public ResponseEntity<Object> save(@Valid @RequestBody ClienteRequestDto dto) {
        CadastrarUseCase cadastrarUseCase = new CadastrarUseCase(clienteService);
        try {
            var result = cadastrarUseCase.execute(new Cliente(dto.nome()));
            return ResponseEntity.ok().body(result);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/all")
    public ResponseEntity<Object> findAll() {
        FindAllClienteUseCase findAllClienteUseCase = new FindAllClienteUseCase(clienteService);
        try {
            var result = findAllClienteUseCase.execute();
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Integer id) {
        FindByIdClienteUseCase useCase = new FindByIdClienteUseCase(clienteService);
        try {
            Optional<Cliente> cliente = useCase.execute(id);
            if(cliente.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente not found...");
            }
            return ResponseEntity.status(HttpStatus.OK).body(cliente);
        }catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        FindByIdClienteUseCase useCase = new FindByIdClienteUseCase(clienteService);
        DeleteClienteUseCase deleteUseCase = new DeleteClienteUseCase(clienteService);
        Optional<Cliente> cliente = useCase.execute(id);
        if(cliente.isPresent()) {
            deleteUseCase.execute(cliente.get());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto("Cliente nao encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Object> update (@PathVariable Integer id, @RequestBody Cliente cliente) {
        FindByIdClienteUseCase findUseCase = new FindByIdClienteUseCase(clienteService);
        UpdateUseCase updateUseCase = new UpdateUseCase(clienteService);

        return findUseCase.execute(id)
                .map(cli -> {
                    cliente.setId(cli.getId());
                    updateUseCase.execute(cliente);
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());

    }

}
