package com.rlti.gestaoservicos.usuario.application.service;

import com.rlti.gestaoservicos.configs.security.service.UserDetailsApplicationService;
import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.usuario.application.api.UsuarioRequest;
import com.rlti.gestaoservicos.usuario.application.api.UsuarioResponse;
import com.rlti.gestaoservicos.usuario.application.repository.RoleRepository;
import com.rlti.gestaoservicos.usuario.application.repository.UsuarioRepository;
import com.rlti.gestaoservicos.usuario.domain.Role;
import com.rlti.gestaoservicos.usuario.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class UsuarioApplicationService implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UserDetailsApplicationService userDetailsApplicationService;
    private final RoleRepository roleRepository;

    @Override
    public UsuarioResponse novoUsuario(UsuarioRequest usuarioRequest) {
        log.info("[inicia] UsuarioApplicationService - novoUsuario");
        Role role = roleRepository.findByRole(usuarioRequest.getRoleName());
        Usuario usuario = usuarioRepository.salva(new Usuario(usuarioRequest, role));
        log.info("[finaliza] UsuarioApplicationService - novoUsuario");
        return new UsuarioResponse(usuario);
    }

    @Override
    public Usuario findByUsuario(String usuario) {
        log.info("[inicia] UsuarioApplicationService - findByUsuario");
        Usuario response = usuarioRepository.findByUsuario(usuario)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
        log.info("[finaliza] UsuarioApplicationService - findByUsuario");
        return (response);
    }
}