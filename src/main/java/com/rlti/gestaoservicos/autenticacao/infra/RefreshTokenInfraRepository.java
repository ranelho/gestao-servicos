package com.rlti.gestaoservicos.autenticacao.infra;

import com.rlti.gestaoservicos.autenticacao.application.repository.RefreshTokenRepository;
import com.rlti.gestaoservicos.autenticacao.domain.RefreshToken;

import java.util.Optional;

public class RefreshTokenInfraRepository implements RefreshTokenRepository {
    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return Optional.empty();
    }
}
