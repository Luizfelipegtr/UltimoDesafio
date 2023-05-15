package com.br.edusync.Desafio.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "tb_cliente")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cpf;

    private String name;

    private Integer number;

    @JoinColumn
    @ManyToOne
    private MedicoModel medicoModel;

}
