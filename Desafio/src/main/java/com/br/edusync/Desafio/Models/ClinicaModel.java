package com.br.edusync.Desafio.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "tb_clinica")
public class ClinicaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clinicaid;

    private String cnpj;

    private Integer number;
}
