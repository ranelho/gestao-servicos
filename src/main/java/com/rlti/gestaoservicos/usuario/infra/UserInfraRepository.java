package com.rlti.gestaoservicos.usuario.infra;

import com.rlti.gestaoservicos.usuario.application.repository.UserRepository;
import com.rlti.gestaoservicos.usuario.domain.Role;
import com.rlti.gestaoservicos.usuario.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@ResponseStatus
@Log4j2
@RequiredArgsConstructor
@Repository
public class UserInfraRepository implements UserRepository {

    private final UserSpringDataJPARepository userSpringDataJPARepository;
    private final RoleSpingDataJPARepository roleSpingDataJPARepository;

    @Override
    public User salva(User usuario) {
        log.info("[inicia] UserInfraRepository - salva");
        userSpringDataJPARepository.save(usuario);
        log.info("[finaliza] UserInfraRepository - salva");
        return usuario;
    }

    @Override
    public Role salvaRole(Role role) {
        log.info("[inicia] UserInfraRepository - salvaRole");
        roleSpingDataJPARepository.save(role);
        log.info("[finaliza] UserInfraRepository - salvaRole");
        return role;
    }

    @Override
    public List<Object> findById(Long userId) {
        return null;
    }

    @Override
    public Optional<User> findUsuarioById(UUID userId) {
        log.info("[inicia] UserInfraRepository - findByUsuario");
        Optional<User> optionalUser = userSpringDataJPARepository.findById(userId);
        log.info("[finaliza] UserInfraRepository - findByUsuario");
        return  optionalUser;
    }

    @Override
    public Optional<User> findByUsuario(String usuario) {
        log.info("[inicia] UserInfraRepository - findByUsuario");
        Optional<User> user = userSpringDataJPARepository.findByUsername(usuario);
        log.info("[finaliza] UserInfraRepository - findByUsuario");
        return user;
    }
}