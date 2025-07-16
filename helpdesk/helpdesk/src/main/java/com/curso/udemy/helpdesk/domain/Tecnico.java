package com.curso.udemy.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import com.curso.udemy.helpdesk.domain.enums.Perfil;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;



@Entity
public class Tecnico extends Pessoa{

    public static final long serialVersionUID=1L;

    @OneToMany(mappedBy = "tecnico")
     private List<Chamado> chamados=new ArrayList<Chamado>();

     public Tecnico() {
        super();
        addPerfil(Perfil.TECNICO);
     }

     public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.TECNICO);
     }

     public List<Chamado> getChamados() {
         return chamados;
     }

     public void setChamados(List<Chamado> chamados) {
         this.chamados = chamados;
     }

     
}
