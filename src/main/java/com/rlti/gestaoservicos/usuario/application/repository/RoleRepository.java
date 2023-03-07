package com.rlti.gestaoservicos.usuario.application.repository;

import com.rlti.gestaoservicos.usuario.domain.Role;

public interface RoleRepository {
    Role findByRole(String roleName);
}
