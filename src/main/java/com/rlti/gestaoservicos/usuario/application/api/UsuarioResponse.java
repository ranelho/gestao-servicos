package com.rlti.gestaoservicos.usuario.application.api;

import com.rlti.gestaoservicos.usuario.domain.Usuario;
import lombok.Value;

import java.util.UUID;

@Value
public class UsuarioResponse {
    private UUID userId;
    private String userName;

    public UsuarioResponse(Usuario usuario) {
        this.userId = usuario.getUserId();
        this.userName = usuario.getUsername();
    }
}
