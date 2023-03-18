package com.rlti.gestaoservicos.usuario.application.repository;

import com.rlti.gestaoservicos.usuario.domain.Role;
import com.rlti.gestaoservicos.usuario.domain.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findByUsuario(String username);
    User salva(User usuario);
    Role salvaRole(Role role);

    List<Object> findById(Long userId);
    Optional<User> findUsuarioById(UUID userId);
}
