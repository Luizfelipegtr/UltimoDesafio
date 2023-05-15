package com.br.edusync.Desafio.Repository;

import com.br.edusync.Desafio.Models.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ConsultaRepository extends JpaRepository<ConsultaModel,Integer> {
}
