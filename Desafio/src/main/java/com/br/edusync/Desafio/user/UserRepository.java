package com.br.edusync.Desafio.user;

import com.br.edusync.Desafio.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findByEmail(String email);

    public UserModel findByUsername(String username);
}
