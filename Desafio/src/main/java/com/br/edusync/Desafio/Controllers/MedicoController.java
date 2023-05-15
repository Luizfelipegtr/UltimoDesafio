package com.br.edusync.Desafio.Controllers;

import com.br.edusync.Desafio.Models.MedicoModel;
import com.br.edusync.Desafio.Repository.MedicoRepository;
import com.br.edusync.Desafio.Services.MedicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/Medico")
public class MedicoController {
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private MedicoService medicoService;

    @PostMapping
    @Operation(summary = "adicionar medicos", description = "adiciona um medico")
    @ApiResponse(responseCode = "201", description = "O medico foi adicionado com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity addmedico(@RequestBody MedicoModel medicoModel) {
        medicoService.adicionar(medicoModel);
        return new ResponseEntity(medicoModel, HttpStatus.CREATED);
    }



    @GetMapping
    @Operation(summary = "Listar tudo", description = "Faz a listagem de todas os medicos")
    @ApiResponse(responseCode = "201", description = "Todos os medicos foram listadas com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity listartudo(){
        return new ResponseEntity<>(medicoService.listartudo(),HttpStatus.OK);
    }



    @GetMapping(value = "/{id}")
    @Operation(summary = "Buscar por id", description = "Faz a listagem dos medicos ")
    @ApiResponse(responseCode = "201", description = "Todos os medicos foram listados com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity buscarporid(@RequestParam Integer id){
        return new ResponseEntity<>(medicoService.buscarporid(id),HttpStatus.OK);
    }



    @PutMapping(value = "/{id}")
    @Operation(summary = "alterar metodo", description = "altera uma medico pelo id")
    @ApiResponse(responseCode = "201", description = "alterado com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity alterar(@PathVariable Integer id, @RequestBody MedicoModel medicoModel){
        medicoService.update(id,medicoModel);
        return new ResponseEntity<>(medicoModel,HttpStatus.OK);
    }



    @DeleteMapping(value = "/{id}")
    @ApiResponse(responseCode = "201", description = "Medico removido com sucesso!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    @Operation(summary = "remover medico",description = "metodo para remover medico pelo id")
    public ResponseEntity remover(@PathVariable Integer id) {
        medicoService.remover(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
