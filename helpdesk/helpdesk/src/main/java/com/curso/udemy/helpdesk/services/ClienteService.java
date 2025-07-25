package com.curso.udemy.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.curso.udemy.helpdesk.domain.Cliente;
import com.curso.udemy.helpdesk.domain.Pessoa;
import com.curso.udemy.helpdesk.domain.dtos.ClienteDTO;
import com.curso.udemy.helpdesk.repositories.ClienteRepository;
import com.curso.udemy.helpdesk.repositories.PessoaRepository;
import com.curso.udemy.helpdesk.services.exceptions.ObjectnotFoundException;
import com.curso.udemy.helpdesk.services.exceptions.DataIntegrityViolationException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
	private PasswordEncoder encoder;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! id: " + id));
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente create(ClienteDTO objDTO) {
        objDTO.setId(null);
        objDTO.setSenha(encoder.encode(objDTO.getSenha()));
        validaPorCpfEmail(objDTO);
        Cliente newObj = new Cliente(objDTO);
        return repository.save(newObj);
    }

    public Cliente update(Integer id,ClienteDTO objDTO) {
        objDTO.setId(id);
        Cliente oldObj=findById(id);
        validaPorCpfEmail(objDTO);
        oldObj = new Cliente(objDTO);
        return repository.save(oldObj);
    }

     public void delete(Integer id) {
        Cliente obj=findById(id);
        if (obj.getChamados().size()>0){
            throw new DataIntegrityViolationException("Cliente possui ordens de serviço e não pode ser deletado!");
        }
        repository.deleteById(id);
    }

    private void validaPorCpfEmail(ClienteDTO objDTO) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
        if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }
        obj = pessoaRepository.findByEmail(objDTO.getEmail());
        if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
        }
    }

   

    

}
