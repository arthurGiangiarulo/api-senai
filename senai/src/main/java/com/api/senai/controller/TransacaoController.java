package com.api.senai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.senai.classes.Transacao;
import com.api.senai.service.TransacaoService;

public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public ResponseEntity<List<Transacao>> getAll() {
        return ResponseEntity.ok(transacaoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> getById(@PathVariable Long id) {
        return ResponseEntity.ok(transacaoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Transacao> create(@RequestBody Transacao transacao) {
        return ResponseEntity.ok(transacaoService.create(transacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transacao> update(@PathVariable Long id, @RequestBody Transacao transacao) {
        return ResponseEntity.ok(transacaoService.update(id, transacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    

}
