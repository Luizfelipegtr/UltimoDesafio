package com.br.edusync.Desafio.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "tb_medico")
public class MedicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer crm;

    private String name;

    private Integer number;

    private String cpf;

    @JoinColumn
    @ManyToOne
    private ClinicaModel clinicaModel;

    @JoinColumn
    @ManyToOne
    private ConsultaModel consultaModel;



}