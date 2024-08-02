package com.api.senai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.senai.classes.ContaBancaria;
import com.api.senai.repository.ContaBancariaRepository;

public class ContaBancariaService {

    @Autowired
    ContaBancariaRepository contaBancariaRepository;

    public List<ContaBancaria> getAll() {
        return contaBancariaRepository.findAll();
    }

    public ContaBancaria getById(Long id) {
        return contaBancariaRepository.findById(id).orElse(null);
    }

    public ContaBancaria create(ContaBancaria contaBancaria) {
        return contaBancariaRepository.save(contaBancaria);
    }

    public ContaBancaria update(Long id, ContaBancaria contaBancaria) {
        // contaBancaria.setId(id);
        return contaBancariaRepository.save(contaBancaria);
    }

    public ContaBancaria delete(Long id) {
        ContaBancaria contaBancaria = getById(id);
        contaBancariaRepository.delete(contaBancaria);
        return contaBancaria;
    }

}
