package com.br.edusync.Desafio.Repository;

import com.br.edusync.Desafio.Models.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MedicoRepository extends JpaRepository<MedicoModel,Integer> {
}
