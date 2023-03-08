package com.rlti.gestaoservicos.usuario.application.service;

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
    public Usuario buscaCredencialPorUsuario(Usuario usuario) {
        log.info("[inicia] CredencialSpringDataJpaService - buscaCredencial");
        Usuario credencial = usuarioRepository.findByUserName(usuario.getUsername());
        log.info("[finaliza] CredencialSpringDataJpaService - buscaCredencial");
        return credencial;

    }

    @Override
    public Usuario findCredencialByUsuario(String user) {
        log.info("[inicia] UsuarioApplicationService - findCredencialByUsuario");
        Usuario credencial = usuarioRepository.findByUserName(user);
        log.info("[finaliza] UsuarioApplicationService - findCredencialByUsuario");
        return credencial;
    }
}