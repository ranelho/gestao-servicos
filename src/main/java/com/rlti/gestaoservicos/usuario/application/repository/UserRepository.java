package com.rlti.gestaoservicos.usuario.application.repository;

import com.rlti.gestaoservicos.usuario.domain.Usuario;

public interface UserRepository {
    Usuario findByUserName(String username);
}
