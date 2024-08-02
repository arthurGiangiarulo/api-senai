package com.api.senai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.senai.classes.Transacao;

public class TransacaoService {

    @Autowired
    TransacaoRepository transacaoRepository;

    public List<Transacao> getAll() {
        return transacaoRepository.findAll();
    }

    public Transacao getById(Long id) {
        return transacaoRepository.findById(id).orElse(null);
    }

    public Transacao create(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public Transacao update(Long id, Transacao transacao) {
        Transacao transacao = transacaoRepository.findById(id).orElse(null);
        if (transacao == null) {
            return null;
        }
        return transacaoRepository.save(transacao);
    }

    public void delete(Long id) {
        transacaoRepository.deleteById(id);
    }

}
