package com.rlti.gestaoservicos.usuario.infra;

import com.rlti.gestaoservicos.usuario.application.repository.UserRepository;
import com.rlti.gestaoservicos.usuario.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
    public User findByUserName(String username) {
        log.info("[inicia] UserInfraRepository - findByUserName");
        Optional<User> optionalUser = userSpringDataJPARepository.findByUserName(username);
        User user = optionalUser
                .orElseThrow( () -> new UsernameNotFoundException("Usuário não encontrado: " + username));
        log.info("[finaliza] UserInfraRepository - findByUserName");
        return user;
    }
}