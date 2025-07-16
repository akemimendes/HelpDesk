package com.curso.udemy.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.udemy.helpdesk.domain.Chamado;


public interface ChamadoRepository extends JpaRepository<Chamado,Integer> {

}
