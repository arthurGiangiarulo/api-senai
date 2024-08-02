package com.api.senai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.senai.classes.Endereco;
import com.api.senai.repository.EnderecoRepository;

public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public List<Endereco> getAll() {
        return enderecoRepository.findAll();
    }

    public Endereco getById(Long id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    public Endereco create(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco update(Long id, Endereco endereco) {
        endereco.setId(id);
        return enderecoRepository.save(endereco);
    }

    public Endereco delete(Long id) {
        Endereco endereco = getById(id);
        enderecoRepository.delete(endereco);
        return endereco;
    }
}
