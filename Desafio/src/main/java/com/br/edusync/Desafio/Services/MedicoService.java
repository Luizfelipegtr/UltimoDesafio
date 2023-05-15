package com.br.edusync.Desafio.Services;

import com.br.edusync.Desafio.Models.MedicoModel;
import com.br.edusync.Desafio.Repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MedicoService {

    public MedicoRepository medicoRepository;


    public void adicionar(MedicoModel medicoModel){
        medicoRepository.save(medicoModel);
    }



    public Object listartudo(){
        return medicoRepository.findAll();
    }




    public MedicoModel buscarporid(Integer medicoid) {
        Optional<MedicoModel> optmedico = medicoRepository.findById(medicoid);

        if(optmedico.isEmpty()){

            throw new NoSuchElementException("medico não encontrado!");
        }
        return optmedico.get();
    }



    public void update(Integer medicoid, MedicoModel medicoModel) {
        remover(medicoid);
        adicionar(medicoModel);
    }



    public void remover(Integer medicoid) {
        medicoRepository.deleteById(medicoid);
    }
}
