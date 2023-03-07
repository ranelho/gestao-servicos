package com.rlti.gestaoservicos.usuario.application.api;

import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Value
public class UsuarioRequest {
    @NotNull
    @Email
    private String userName;
    @NotNull
    private String password;
    private String roleName;
}