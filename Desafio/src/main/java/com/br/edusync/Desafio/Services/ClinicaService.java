package com.br.edusync.Desafio.Services;


import com.br.edusync.Desafio.Models.ClinicaModel;
import com.br.edusync.Desafio.Repository.ClinicaRepository;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class ClinicaService {

    public ClinicaRepository clinicaRepository;


    public void adicionar(ClinicaModel clinicaModel){
        clinicaRepository.save(clinicaModel);
    }



    public Object listartudo(){
        return clinicaRepository.findAll();
    }




    public ClinicaModel buscarporid(Integer clinicaid) {
        Optional<ClinicaModel> optclinica = clinicaRepository.findById(clinicaid);
        return optclinica.get();
    }



    public void update(Integer clinicaId, ClinicaModel clinicaModel) {
        remover(clinicaId);
        adicionar(clinicaModel);
    }



    public void remover(Integer clinicaid) {
        clinicaRepository.deleteById(clinicaid);
    }

}
