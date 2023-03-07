package com.rlti.gestaoservicos.usuario.infra;

import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.usuario.application.repository.UserRepository;
import com.rlti.gestaoservicos.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@ResponseStatus
@Log4j2
@RequiredArgsConstructor
@Repository
public class UserInfraRepository implements UserRepository {

    private final UserSpringDataJPARepository userSpringDataJPARepository;

    @Override
    public Usuario salva(Usuario usuario) {
        log.info("[inicia] UserInfraRepository - salva");
        userSpringDataJPARepository.save(usuario);
        log.info("[finaliza] UserInfraRepository - salva");
        return usuario;
    }

    @Override
    public Usuario findByUserName(String username) {
        log.info("[inicia] UserInfraRepository - findByUserName");
        var usuario = userSpringDataJPARepository.findByUserName(username)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Não existe cred encial para o Usuario informado!"));
        log.info("[finaliza] UserInfraRepository - findByUserName");
        return usuario;
    }
}