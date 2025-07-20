package com.curso.udemy.helpdesk.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.udemy.helpdesk.domain.Chamado;
import com.curso.udemy.helpdesk.domain.Cliente;
import com.curso.udemy.helpdesk.domain.Tecnico;
import com.curso.udemy.helpdesk.domain.dtos.ChamadoDTO;
import com.curso.udemy.helpdesk.domain.enums.Prioridade;
import com.curso.udemy.helpdesk.domain.enums.Status;
import com.curso.udemy.helpdesk.repositories.ChamadoRepository;
import com.curso.udemy.helpdesk.services.exceptions.ObjectnotFoundException;


@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository repository;
    @Autowired
    private TecnicoService tecnicoService;
    @Autowired
    private ClienteService clienteService;

    public Chamado findById(Integer id) {
        Optional<Chamado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! id: " + id));

    }

    public List<Chamado> findByAll() {
        return repository.findAll();
    }

    public Chamado create(ChamadoDTO chamadoDTO) {
       return repository.save(newChamado(chamadoDTO));
    }

     public Chamado update(Integer id,ChamadoDTO objDTO) {
        objDTO.setId(id);
        Chamado oldObj=findById(id);
        oldObj=newChamado(objDTO);
        return repository.save(oldObj);
    }

    private Chamado newChamado(ChamadoDTO obj){
        Tecnico tecnico=tecnicoService.findById(obj.getTecnico());
        Cliente cliente=clienteService.findById(obj.getCliente());
        Chamado chamado=new Chamado();
        if (obj.getId()!=null){
            chamado.setId(obj.getId());
        }
        if (obj.getStatus().equals(2)){
            chamado.setDataFechamento(LocalDate.now());
        }
        chamado.setCliente(cliente);
        chamado.setTecnico(tecnico);
        chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
        chamado.setStatus(Status.toEnum(obj.getStatus()));
        chamado.setTitulo(obj.getTitulo());
        chamado.setObservacoes(obj.getObservacoes());
        return chamado;
    }

   
}
