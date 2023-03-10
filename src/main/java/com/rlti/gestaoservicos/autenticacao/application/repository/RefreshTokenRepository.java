package com.rlti.gestaoservicos.autenticacao.application.repository;

import com.rlti.gestaoservicos.autenticacao.domain.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository {
    Optional<RefreshToken> findByToken(String token);
}
