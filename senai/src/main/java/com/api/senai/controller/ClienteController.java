package com.api.senai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.senai.classes.Cliente;
import com.api.senai.dto.ClienteDTO;
import com.api.senai.dto.ClienteUpdateDTO;
import com.api.senai.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Buscar todos os clientes - getAll
    @Operation(
        summary = "Buscar todos os clientes", 
        description = "Retorna uma lista com todos os clientes cadastrados",
        deprecated = true
    )
    @ApiResponse(responseCode = "200", description = "Clientes encontrados")
    @ApiResponse(responseCode = "404", description = "Clientes não encontrados")
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> clientes = clienteService.getAll();
        if (clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes);
    }

    // Buscar todos os clientes ativos
    @Operation(summary = "Buscar todos os clientes ativos")
    @GetMapping("/ativos")
    public ResponseEntity<List<Cliente>> getAllAtivos() {
        List<Cliente> clientes = clienteService.getAllAtivos();
        return ResponseEntity.ok(clientes);
    }
    
    // Buscar um cliente por id - getById
    // @Operation(summary = "Buscar um cliente por id", method = "GET")
    // @ApiResponse(responseCode = "200", description = "Cliente encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id) {
        Cliente cliente = clienteService.getById(id);

        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @Operation(summary = "Buscar todos os clientes com DTO", tags = {"Cliente"})
    // @ApiResponse(responseCode = "200", description = "Clientes encontrados")
    @GetMapping("/nomes")
    public ResponseEntity<List<ClienteDTO>> getClientesDTO() {
        return ResponseEntity.ok(clienteService.getClientesDTO());
    }

    // Criar um cliente - create
    // @Operation(summary = "Criar um cliente", method = "POST")
    // @ApiResponse(responseCode = "200", description = "Cliente cadastrado")
    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteService.create(cliente);
        
        return ResponseEntity.ok(clienteSalvo);
    }

    // Atualizar um cliente - update
    // Combinação do getById e create
    // @Operation(summary = "Atualizar um cliente", method = "PUT")
    // @ApiResponse(responseCode = "200", description = "Cliente atualizado")
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente clienteNovo) {
        Cliente clienteExistente = clienteService.getById(id);

        if (clienteExistente == null) {
            return ResponseEntity.notFound().build();
        }
        Cliente clienteSalvo = clienteService.update(id, clienteExistente, clienteNovo);

        return ResponseEntity.ok(clienteSalvo);
    }

    @Operation(summary = "Atualizar um cliente com DTO", tags = {"Cliente"})
    // @ApiResponse(responseCode = "200", description = "Cliente atualizado")
    @PutMapping("/dto/{id}")
    public ResponseEntity<ClienteUpdateDTO> updateDTO (@PathVariable Long id, @RequestBody ClienteUpdateDTO clienteNovo) {
        Cliente clienteExistente = clienteService.getById(id);

        if (clienteExistente == null) {
            return ResponseEntity.notFound().build();
        }

        ClienteUpdateDTO clienteDTO = clienteService.updateDTO(clienteExistente, clienteNovo);

        return ResponseEntity.ok(clienteDTO);

    }

    // Deletar um cliente - delete
    // @Operation(summary = "Deletar um cliente")
    // @ApiResponse(responseCode = "200", description = "Cliente deletado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Long id) {
        Cliente cliente = clienteService.getById(id);

        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteService.delete(id));
    }    
}
