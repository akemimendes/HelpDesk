package com.curso.udemy.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.udemy.helpdesk.domain.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

}
