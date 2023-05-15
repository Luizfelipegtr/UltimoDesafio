package com.br.edusync.Desafio.Models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity(name = "tb_consulta")
public class ConsultaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer consultaid;

    private LocalDate date;

    @JoinColumn
    @ManyToOne
    private ClinicaModel clinicaModel;

}
