package com.br.edusync.Desafio.Repository;

import com.br.edusync.Desafio.Models.ClinicaModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClinicaRepository extends JpaRepository<ClinicaModel,Integer> {
}
