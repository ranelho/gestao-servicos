package com.rlti.gestaoservicos.config.security.services;

import com.rlti.gestaoservicos.autenticacao.domain.RefreshToken;
import com.rlti.gestaoservicos.autenticacao.infra.RefreshTokenSpringDataJPARepository;
import com.rlti.gestaoservicos.config.security.exception.TokenRefreshException;
import com.rlti.gestaoservicos.usuario.infra.UserSpringDataJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {
  @Value("${servico.jwt.jwtRefreshExpirationMs}")
  private Long refreshTokenDurationMs;

  @Autowired
  private RefreshTokenSpringDataJPARepository refreshTokenRepository;

  @Autowired
  private UserSpringDataJPARepository userRepository;

  public Optional<RefreshToken> findByToken(String token) {
    return refreshTokenRepository.findByToken(token);
  }

  public RefreshToken createRefreshToken(UUID userId) {
    RefreshToken refreshToken = new RefreshToken();
    refreshToken.setUser(userRepository.findById(userId).get());
    refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
    refreshToken.setToken(UUID.randomUUID().toString());
    refreshToken = refreshTokenRepository.save(refreshToken);
    return refreshToken;
  }

  public RefreshToken verifyExpiration(RefreshToken token) {
    if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
      refreshTokenRepository.delete(token);
      throw new TokenRefreshException(token.getToken(), "Refresh token was expired. Please make a new signin request");
    }
    return token;
  }

  @Transactional
  public int deleteByUserId(UUID userId) {
    return refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
  }
}
