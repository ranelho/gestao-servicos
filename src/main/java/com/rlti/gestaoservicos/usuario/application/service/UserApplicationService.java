package com.rlti.gestaoservicos.usuario.application.service;

import com.rlti.gestaoservicos.config.security.services.UserDetailsApplicationService;
import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.usuario.application.api.request.RoleRuquest;
import com.rlti.gestaoservicos.usuario.application.api.request.UserRequest;
import com.rlti.gestaoservicos.usuario.application.api.response.RoleResponse;
import com.rlti.gestaoservicos.usuario.application.api.response.UserResponse;
import com.rlti.gestaoservicos.usuario.application.repository.RoleRepository;
import com.rlti.gestaoservicos.usuario.application.repository.UserRepository;
import com.rlti.gestaoservicos.usuario.domain.Role;
import com.rlti.gestaoservicos.usuario.domain.User;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Log4j2
public class UserApplicationService implements UserService {

    private final UserRepository usuarioRepository;
    private final UserDetailsApplicationService userDetailsApplicationService;
    private final RoleRepository roleRepository;

    @Override
    public UserResponse novoUsuario(UserRequest usuarioRequest) {
        log.info("[inicia] UsuarioApplicationService - novoUsuario");
        Role role = roleRepository.findByRoleName(usuarioRequest.getName());
        User usuario = usuarioRepository.salva(new User(usuarioRequest, role));
        log.info("[finaliza] UsuarioApplicationService - novoUsuario");
        return new UserResponse(usuario);
    }

    @Override
    public RoleResponse novaRole(RoleRuquest roleRuquest) {
        log.info("[inicia] UsuarioApplicationService - novaRole");
        if(roleRepository.findByName(roleRuquest.getName()).isPresent()) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Role já cadastrada!");
        }else {
            Role role = usuarioRepository.salvaRole(new Role(roleRuquest));
            log.info("[finaliza] UsuarioApplicationService - novaRole");
            return new RoleResponse(role);
        }
    }

    @Override
    public User findById(UUID userId) {
        log.info("[inicia] UsuarioApplicationService - findById");
        User response = usuarioRepository.findUsuarioById(userId)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
        log.info("[finaliza] UsuarioApplicationService - findById");
        return  response;
    }

    @Override
    public User findByUsuario(String usuario) {
        log.info("[inicia] UsuarioApplicationService - findByUsuario");
        User response = usuarioRepository.findByUsuario(usuario)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
        log.info("[finaliza] UsuarioApplicationService - findByUsuario");
        return (response);
    }
}