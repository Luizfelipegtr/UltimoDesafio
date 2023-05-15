package com.br.edusync.Desafio.Controllers;

import com.br.edusync.Desafio.Models.ClienteModel;
import com.br.edusync.Desafio.Models.MedicoModel;
import com.br.edusync.Desafio.Repository.ClienteRepository;
import com.br.edusync.Desafio.Services.Clienteservice;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private Clienteservice clienteservice;

    @PostMapping
    @Operation(summary = "adicionar cliente", description = "adiciona um cliente")
    @ApiResponse(responseCode = "201", description = "O cliente foi adicionado com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity addcliente(@RequestBody ClienteModel medicoModel) {
        clienteservice.adicionar(medicoModel);
        return new ResponseEntity(medicoModel, HttpStatus.CREATED);
    }



    @GetMapping
    @Operation(summary = "Listar tudo", description = "Faz a listagem de todas os medicos")
    @ApiResponse(responseCode = "201", description = "Todos os medicos foram listadas com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity listartudo(){
        return new ResponseEntity<>(clienteservice.listartudo(),HttpStatus.OK);
    }



    @GetMapping(value = "/{id}")
    @Operation(summary = "Buscar por id", description = "Faz a listagem dos clientess ")
    @ApiResponse(responseCode = "201", description = "Todos os clientes foram listados com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity buscarporid(@RequestParam Integer id){
        return new ResponseEntity<>(clienteservice.buscarporid(id),HttpStatus.OK);
    }



    @PutMapping(value = "/{id}")
    @Operation(summary = "alterar metodo", description = "altera uma medico pelo id")
    @ApiResponse(responseCode = "201", description = "alterado com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity alterar(@PathVariable Integer id, @RequestBody ClienteModel clienteModel){
        clienteservice.update(id,clienteModel);
        return new ResponseEntity<>(clienteModel,HttpStatus.OK);
    }



    @DeleteMapping(value = "/{id}")
    @ApiResponse(responseCode = "201", description = "Medico removido com sucesso!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    @Operation(summary = "remover medico",description = "metodo para remover medico pelo id")
    public ResponseEntity remover(@PathVariable Integer id) {
        clienteservice.remover(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
