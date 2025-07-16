package com.curso.udemy.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.udemy.helpdesk.domain.*;
import com.curso.udemy.helpdesk.domain.enums.Perfil;
import com.curso.udemy.helpdesk.domain.enums.Prioridade;
import com.curso.udemy.helpdesk.domain.enums.Status;
import com.curso.udemy.helpdesk.repositories.ChamadoRepository;
import com.curso.udemy.helpdesk.repositories.ClienteRepository;
import com.curso.udemy.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner{

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;


	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1=new Tecnico(null,"Akemi Mendes","012.563.445-88","akemi@hotmail.com","123456");
		tec1.addPerfil(Perfil.ADMIN);
		Cliente cli1=new Cliente(null,"Mateus Sugaya","052.445.001-58","mateus@hotmail.com","onepeace");
		Chamado c1=new Chamado(null,Prioridade.MEDIA,Status.ANDAMENTO,"Chamado 01","Primeiro chamado",tec1,cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}
