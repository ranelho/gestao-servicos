package com.rlti.gestaoservicos.usuario.infra;

import com.rlti.gestaoservicos.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserSpringDataJPARepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByUsuario(String usuario);
}
