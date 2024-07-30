package com.api.senai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.senai.classes.Cliente;
import com.api.senai.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Buscar todos os clientes - getAll
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        return clienteService.getAll();
    }

    // Criar um cliente - create
    // @PostMapping
    // public String create(@RequestBody Cliente cliente) {
    //     Cliente.clientes.add(cliente);
    //     return "Cliente cadastrado com sucesso!";
    // }

    // Buscar um cliente por id - getById
    // @GetMapping("/{id}")
    // public String getById(@PathVariable UUID id) {
    //     for (Cliente cliente : Cliente.clientes) {
    //         if (cliente.getId().equals(id)) {
    //             return cliente.toString();
    //         }
    //     }
    //     return "Cliente não encontrado.";
    // }

    // Atualizar um cliente - update

    // Deletar um cliente - delete
    
}
