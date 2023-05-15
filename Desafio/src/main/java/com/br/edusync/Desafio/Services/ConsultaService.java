package com.br.edusync.Desafio.Services;

import com.br.edusync.Desafio.Models.ConsultaModel;
import com.br.edusync.Desafio.Repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ConsultaService {
    public ConsultaRepository consultaRepository;


    public void adicionar(ConsultaModel consultaModel){
        consultaRepository.save(consultaModel);
    }



    public Object listartudo(){
        return consultaRepository.findAll();
    }




    public ConsultaModel buscarporid(Integer consultaid) {
        Optional<ConsultaModel> optconsulta = consultaRepository.findById(consultaid);

        if(optconsulta.isEmpty()){

            throw new NoSuchElementException("funcionario não encontrado!");
        }
        return optconsulta.get();
    }



    public void update(Integer consultaId, ConsultaModel consultaModel) {
        remover(consultaId);
        adicionar(consultaModel);
    }



    public void remover(Integer consultaid) {
        consultaRepository.deleteById(consultaid);
    }
}
