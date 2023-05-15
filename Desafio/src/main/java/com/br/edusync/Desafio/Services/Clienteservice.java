package com.br.edusync.Desafio.Services;

import com.br.edusync.Desafio.Models.ClienteModel;
import com.br.edusync.Desafio.Repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class Clienteservice {
    public ClienteRepository clienteRepository;


    public void adicionar(ClienteModel clienteModel){
        clienteRepository.save(clienteModel);
    }



    public Object listartudo(){
        return clienteRepository.findAll();
    }




    public ClienteModel buscarporid(Integer clienteid) {
        Optional<ClienteModel> optcliente = clienteRepository.findById(clienteid);

        if(optcliente.isEmpty()){

            throw new NoSuchElementException("funcionario não encontrado!");
        }
        return optcliente.get();
    }



    public void update(Integer clienteid, ClienteModel clienteModel) {
        remover(clienteid);
        adicionar(clienteModel);
    }



    public void remover(Integer clienteid) {
        clienteRepository.deleteById(clienteid);
    }
}
