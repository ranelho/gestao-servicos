package com.rlti.gestaoservicos.usuario.application.api.response;

import com.rlti.gestaoservicos.contato.domain.Contato;
import com.rlti.gestaoservicos.usuario.domain.User;
import lombok.Value;

import java.util.UUID;

@Value
public class UserResponse {
    private UUID userId;
    private String usuario;
    private Contato contato;

    public UserResponse(User usuario) {
        this.userId = usuario.getUserId();
        this.usuario = usuario.getUsername();
        this.contato = usuario.getContato();
    }
}