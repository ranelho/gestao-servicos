package com.rlti.gestaoservicos.usuario.application.api.response;

import com.rlti.gestaoservicos.contato.application.api.ContatoResponseUsuario;
import com.rlti.gestaoservicos.usuario.domain.User;
import lombok.Value;

import java.util.UUID;

@Value
public class UserResponse {
    UUID userId;
    String usuario;
    String email;
    ContatoResponseUsuario contato;

    public UserResponse(User usuario) {
        this.userId = usuario.getUserId();
        this.usuario = usuario.getUsername();
        this.email = usuario.getEmail();
        this.contato = new ContatoResponseUsuario(usuario.getContato());
    }
}