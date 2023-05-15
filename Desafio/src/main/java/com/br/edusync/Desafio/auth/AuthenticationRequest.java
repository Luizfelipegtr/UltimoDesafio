package com.br.edusync.Desafio.auth;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AuthenticationRequest {
    private Integer id;
    private String Username;
    private String email;
    private String password;
}