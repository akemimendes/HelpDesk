package com.curso.udemy.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.udemy.helpdesk.domain.Chamado;
import com.curso.udemy.helpdesk.domain.Cliente;
import com.curso.udemy.helpdesk.domain.Tecnico;
import com.curso.udemy.helpdesk.domain.enums.Perfil;
import com.curso.udemy.helpdesk.domain.enums.Prioridade;
import com.curso.udemy.helpdesk.domain.enums.Status;
import com.curso.udemy.helpdesk.repositories.ChamadoRepository;
import com.curso.udemy.helpdesk.repositories.ClienteRepository;
import com.curso.udemy.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

    @Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;


    public void instanciaDB(){
        Tecnico tec1=new Tecnico(null,"Akemi Mendes","012.563.445-88","akemi@hotmail.com","123456");
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2=new Tecnico(null,"Lucas Viana","129.232.144-96","lucas@hotmail.com","jujutso");
		tec2.addPerfil(Perfil.TECNICO);
		Tecnico tec3=new Tecnico(null,"Sabrina Almeida","145.588.654.21","sabrina@hotmail.com","peppa");
		tec2.addPerfil(Perfil.TECNICO);
		Cliente cli1=new Cliente(null,"Mateus Sugaya","052.445.001-58","mateus@hotmail.com","onepeace");
		Chamado c1=new Chamado(null,Prioridade.MEDIA,Status.ANDAMENTO,"Chamado 01","Primeiro chamado",tec1,cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		tecnicoRepository.saveAll(Arrays.asList(tec2));
		tecnicoRepository.saveAll(Arrays.asList(tec3));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
    }

}
