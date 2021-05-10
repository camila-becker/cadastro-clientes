package com.sistema.cadastro.service;

import com.sistema.cadastro.entity.Cliente;
import com.sistema.cadastro.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente cadastrar(final Cliente request){
        return repository.save(request);
    }

    public List<Cliente> listar(){
        return repository.findAll();
    }

    public Cliente alterar(final Cliente request, final Long id){
        final Cliente cliente = repository.findById(id).orElse(null);

        if(cliente == null){
            throw new RuntimeException("Cliente não encontrado!");
        }

        cliente.setNome(request.getNome());
        cliente.setSobrenome(request.getSobrenome());
        cliente.setCpf(request.getCpf());
        cliente.setTelefone(request.getTelefone());

        repository.save(cliente);

        return cliente;
    }

    public void deletar(final Long id){
        final Cliente cliente = repository.findById(id).orElse(null);

        if(cliente == null){
            throw new RuntimeException("Cliente não encontrado!");
        }

        repository.delete(cliente);
    }

}
