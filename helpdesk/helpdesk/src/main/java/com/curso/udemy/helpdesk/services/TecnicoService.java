package com.curso.udemy.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.udemy.helpdesk.domain.Pessoa;
import com.curso.udemy.helpdesk.domain.Tecnico;
import com.curso.udemy.helpdesk.domain.dtos.TecnicoDTO;
import com.curso.udemy.helpdesk.repositories.PessoaRepository;
import com.curso.udemy.helpdesk.repositories.TecnicoRepository;
import com.curso.udemy.helpdesk.services.exceptions.ObjectnotFoundException;
import com.curso.udemy.helpdesk.services.exceptions.DataIntegrityViolationException;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository repository;
    @Autowired
    private PessoaRepository pessoaRepository;
   

    public Tecnico findById(Integer id){
        Optional<Tecnico> obj= repository.findById(id);
        return obj.orElseThrow(()->new ObjectnotFoundException("Objeto não encontrado! id: " +id));
    }

    public List<Tecnico> findAll() {
        return repository.findAll();
    }

    public Tecnico create(TecnicoDTO objDTO){
        objDTO.setId(null);
        validaPorCpfEmail(objDTO);
        Tecnico newObj= new Tecnico(objDTO);
        return repository.save(newObj);
    }

     private void validaPorCpfEmail(TecnicoDTO objDTO) {
       Optional<Pessoa> obj=pessoaRepository.findByCpf(objDTO.getCpf());
       if (obj.isPresent() && obj.get().getId() != objDTO.getId()){
          throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
       }
       obj=pessoaRepository.findByEmail(objDTO.getEmail());
       if (obj.isPresent() && obj.get().getId() != objDTO.getId()){
          throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
       }
    }

}
