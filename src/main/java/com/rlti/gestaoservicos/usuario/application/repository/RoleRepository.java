package com.rlti.gestaoservicos.usuario.application.repository;

import com.rlti.gestaoservicos.usuario.domain.ERole;
import com.rlti.gestaoservicos.usuario.domain.Role;

import java.util.Optional;

public interface RoleRepository {
    Optional<Role> findByName(ERole name);
    Role findByRoleName(String name);
}
