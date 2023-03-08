package com.rlti.gestaoservicos.usuario.application.repository;

import com.rlti.gestaoservicos.usuario.domain.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    Usuario findByUserName(String username);
    Usuario salva(Usuario usuario);
}
