package com.br.edusync.Desafio.Controllers;

import com.br.edusync.Desafio.Models.ClinicaModel;
import com.br.edusync.Desafio.Repository.ClinicaRepository;
import com.br.edusync.Desafio.Services.ClinicaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/Clinica")
public class ClinicaController {
    @Autowired
    private ClinicaRepository clinicaRepository;
    @Autowired
    private ClinicaService clinicaService;

    @PostMapping
    @Operation(summary = "adicionar clinicas", description = "adiciona uma clinica")
    @ApiResponse(responseCode = "201", description = "a clinica foi adicionado com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")






    public ResponseEntity addclinicas(@RequestBody ClinicaModel clinicaModel) {
        clinicaService.adicionar(clinicaModel);
        return new ResponseEntity(clinicaModel, HttpStatus.CREATED);
    }



    @GetMapping
    @Operation(summary = "Listar tudo", description = "Faz a listagem de todas as clinicas")
    @ApiResponse(responseCode = "201", description = "Todos as clinicas foram listadas com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity listartudo(){
        return new ResponseEntity<>(clinicaService.listartudo(),HttpStatus.OK);
    }



    @GetMapping(value = "/{id}")
    @Operation(summary = "Buscar por id", description = "Faz a listagem das clinicas ")
    @ApiResponse(responseCode = "201", description = "Todos as clinicas foram listados com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity buscarporid(@RequestParam Integer id){
        return new ResponseEntity<>(clinicaService.buscarporid(id),HttpStatus.OK);
    }



    @PutMapping(value = "/{id}")
    @Operation(summary = "alterar clinica", description = "altera uma clinica pelo id")
    @ApiResponse(responseCode = "201", description = "alterado com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity alterar(@PathVariable Integer id, @RequestBody ClinicaModel clinicaModel){
        clinicaService.update(id,clinicaModel);
        return new ResponseEntity<>(clinicaModel,HttpStatus.OK);
    }



    @DeleteMapping(value = "/{id}")
    @ApiResponse(responseCode = "201", description = "Clinica removido com sucesso!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    @Operation(summary = "remover clinica",description = "metodo para remover clinica pelo id")
    public ResponseEntity remover(@PathVariable Integer id) {
        clinicaService.remover(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
