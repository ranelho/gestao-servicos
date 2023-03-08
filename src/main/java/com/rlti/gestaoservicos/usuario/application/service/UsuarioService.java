package com.rlti.gestaoservicos.usuario.application.service;

import com.rlti.gestaoservicos.usuario.application.api.UsuarioRequest;
import com.rlti.gestaoservicos.usuario.application.api.UsuarioResponse;
import com.rlti.gestaoservicos.usuario.domain.Usuario;

public interface UsuarioService {
    UsuarioResponse novoUsuario(UsuarioRequest usuarioRequest);
    Usuario buscaCredencialPorUsuario(Usuario usuario);
    Usuario findCredencialByUsuario(String user);
}
