package com.rlti.gestaoservicos.usuario.application.service;

import com.rlti.gestaoservicos.usuario.application.api.UsuarioRequest;
import com.rlti.gestaoservicos.usuario.application.api.UsuarioResponse;

public interface UsuarioService {
    UsuarioResponse novoUsuario(UsuarioRequest usuarioRequest);
}
