package com.rlti.gestaoservicos.usuario.application.api.response;

import com.rlti.gestaoservicos.usuario.domain.ERole;
import com.rlti.gestaoservicos.usuario.domain.Role;
import lombok.Value;

import java.util.UUID;

@Value
public class RoleResponse {
    private UUID id;
    private ERole name;

    public RoleResponse(Role role) {
        this.id = role.getId();
        this.name = role.getName();
    }
}
