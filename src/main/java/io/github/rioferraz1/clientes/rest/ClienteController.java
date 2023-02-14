package io.github.rioferraz1.clientes.rest;


import io.github.rioferraz1.clientes.model.entity.Cliente;
import io.github.rioferraz1.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {


    private final ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository) {

        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar( @RequestBody @Valid Cliente cliente ){

        return repository.save(cliente);
    }
        @GetMapping("{id}")
        public Cliente acharPorId(@PathVariable Integer id){
    return repository
            .findById(id)
            .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

        @DeleteMapping("{id}")
        @ResponseStatus (HttpStatus.NO_CONTENT)
        public void deletar( @PathVariable Integer id ){
            repository
                    .findById(id)
                    .map( cliente -> {
                        repository.delete(cliente);
                        return Void.TYPE;
                    })
                    .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
        public void atualizar ( @PathVariable Integer id, @RequestBody Cliente clienteatualizado ) {
        repository
                .findById(id)
                .map( cliente -> {
                cliente.setNome(clienteatualizado.getNome());
                cliente.setCpf(clienteatualizado.getCpf());
                    return repository.save(cliente);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        }
}

