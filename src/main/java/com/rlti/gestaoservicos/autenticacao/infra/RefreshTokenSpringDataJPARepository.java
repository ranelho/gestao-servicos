package com.rlti.gestaoservicos.autenticacao.infra;

import com.rlti.gestaoservicos.autenticacao.domain.RefreshToken;
import com.rlti.gestaoservicos.usuario.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenSpringDataJPARepository extends JpaRepository<RefreshToken, UUID> {
    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUser(User user);
}
