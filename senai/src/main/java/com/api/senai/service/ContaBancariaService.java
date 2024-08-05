package com.api.senai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.senai.classes.ContaBancaria;
import com.api.senai.repository.ContaBancariaRepository;

public class ContaBancariaService {

    @Autowired
    ContaBancariaRepository contaRepository;

    ContaBancariaService(ContaBancariaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public List<ContaBancaria> getAll() {
        return contaRepository.findAll();
    }

    public ContaBancaria getById(Long id) {
        return contaRepository.findById(id).orElse(null);
    }

    public ContaBancaria create(ContaBancaria contaBancaria) {
        return contaRepository.save(contaBancaria);
    }

    public ContaBancaria update(Long id, ContaBancaria contaBancaria) {
        // contaBancaria.setId(id);
        return contaRepository.save(contaBancaria);
    }

    public ContaBancaria delete(Long id) {
        ContaBancaria contaBancaria = getById(id);
 contaRepository.delete(contaBancaria);
        return contaBancaria;
    }

}
