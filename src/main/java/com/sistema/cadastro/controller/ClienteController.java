package com.sistema.cadastro.controller;

import com.sistema.cadastro.entity.Cliente;
import com.sistema.cadastro.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente cadastrar(@RequestBody @Valid final Cliente request){
        return service.cadastrar(request);
    }

    @GetMapping
    public List<Cliente> listar(){
        return service.listar();
    }

    @PutMapping("/{id}")
    public Cliente alterar(@RequestBody @Valid final Cliente request, @PathVariable("id") final Long id){
        return service.alterar(request, id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id){
        service.deletar(id);
    }
}
