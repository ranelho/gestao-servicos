package com.rlti.gestaoservicos.usuario.application.service;

import com.rlti.gestaoservicos.usuario.application.api.request.RoleRuquest;
import com.rlti.gestaoservicos.usuario.application.api.request.UserRequest;
import com.rlti.gestaoservicos.usuario.application.api.response.RoleResponse;
import com.rlti.gestaoservicos.usuario.application.api.response.UserResponse;
import com.rlti.gestaoservicos.usuario.domain.User;

import java.util.UUID;

public interface UserService {
    UserResponse novoUsuario(UserRequest usuarioRequest);
    User findByUsuario(String usuario);
    RoleResponse novaRole(RoleRuquest roleRuquest);
    User findById(UUID userId);
}
