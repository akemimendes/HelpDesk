package com.curso.udemy.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.udemy.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Integer> {

}
