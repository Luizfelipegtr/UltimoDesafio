package com.br.edusync.Desafio.Controllers;

import com.br.edusync.Desafio.Models.ConsultaModel;
import com.br.edusync.Desafio.Repository.ConsultaRepository;
import com.br.edusync.Desafio.Services.ConsultaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/Consulta")
public class ConsultaController {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    @Operation(summary = "adicionar consulta", description = "adiciona uma consulta")
    @ApiResponse(responseCode = "201", description = "A consulta foi adicionada com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity addcliente(@RequestBody ConsultaModel consultaModel) {
        consultaService.adicionar(consultaModel);
        return new ResponseEntity(consultaModel, HttpStatus.CREATED);
    }



    @GetMapping
    @Operation(summary = "Listar tudo", description = "Faz a listagem de todas as consultas")
    @ApiResponse(responseCode = "201", description = "Todas as consultas foram listadas com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity listartudo(){
        return new ResponseEntity<>(consultaService.listartudo(),HttpStatus.OK);
    }



    @GetMapping(value = "/{id}")
    @Operation(summary = "Buscar por id", description = "Faz a listagem das consultas por id ")
    @ApiResponse(responseCode = "201", description = "Todos as consultas foram listados com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity buscarporid(@RequestParam Integer id){
        return new ResponseEntity<>(consultaService.buscarporid(id),HttpStatus.OK);
    }



    @PutMapping(value = "/{id}")
    @Operation(summary = "alterar metodo", description = "altera uma consulta pelo id")
    @ApiResponse(responseCode = "201", description = "alterado com sucesso!!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    public ResponseEntity alterar(@PathVariable Integer id, @RequestBody ConsultaModel consultaModel){
        consultaService.update(id,consultaModel);
        return new ResponseEntity<>(consultaModel,HttpStatus.OK);
    }



    @DeleteMapping(value = "/{id}")
    @ApiResponse(responseCode = "201", description = "Consulta removida com sucesso!")
    @ApiResponse(responseCode = "404", description = "Erro! Tente novamente.")
    @ApiResponse(responseCode = "500", description = "Erro inesperado!")
    @Operation(summary = "remover Consulta",description = "metodo para remover consulta pelo id")
    public ResponseEntity remover(@PathVariable Integer id) {
        consultaService.remover(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
