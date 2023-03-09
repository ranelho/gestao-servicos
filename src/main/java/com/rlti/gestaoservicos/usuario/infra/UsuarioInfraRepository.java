package com.rlti.gestaoservicos.usuario.infra;

import com.rlti.gestaoservicos.usuario.application.repository.UsuarioRepository;
import com.rlti.gestaoservicos.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@ResponseStatus
@Log4j2
@RequiredArgsConstructor
@Repository
public class UsuarioInfraRepository implements UsuarioRepository {

    private final UserSpringDataJPARepository userSpringDataJPARepository;

    @Override
    public Usuario salva(Usuario usuario) {
        log.info("[inicia] UserInfraRepository - salva");
        userSpringDataJPARepository.save(usuario);
        log.info("[finaliza] UserInfraRepository - salva");
        return usuario;
    }

    @Override
    public Optional<Usuario> findByUsuario(String usuario) {
        log.info("[inicia] UserInfraRepository - findByUsuario");
        Optional<Usuario> user = userSpringDataJPARepository.findByUsuario(usuario);
        log.info("[finaliza] UserInfraRepository - findByUsuario");
        return user;
    }
}