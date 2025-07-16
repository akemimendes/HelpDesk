package com.curso.udemy.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.udemy.helpdesk.domain.Tecnico;


public interface TecnicoRepository extends JpaRepository<Tecnico,Integer> {

}
