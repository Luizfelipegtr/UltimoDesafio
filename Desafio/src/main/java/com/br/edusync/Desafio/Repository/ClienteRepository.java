package com.br.edusync.Desafio.Repository;

import com.br.edusync.Desafio.Models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository extends JpaRepository<ClienteModel,Integer> {
}
