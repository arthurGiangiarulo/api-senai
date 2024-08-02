package com.api.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.senai.classes.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
