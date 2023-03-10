package com.rlti.gestaoservicos.autenticacao.application.service;

import com.rlti.gestaoservicos.autenticacao.application.api.request.TokenRefreshRequest;
import com.rlti.gestaoservicos.autenticacao.application.api.response.JwtResponse;
import com.rlti.gestaoservicos.autenticacao.application.api.response.MessageResponse;
import com.rlti.gestaoservicos.autenticacao.application.api.response.TokenRefreshResponse;
import com.rlti.gestaoservicos.autenticacao.domain.RefreshToken;
import com.rlti.gestaoservicos.config.security.exception.TokenRefreshException;
import com.rlti.gestaoservicos.config.security.jwt.JwtUtils;
import com.rlti.gestaoservicos.config.security.services.RefreshTokenService;
import com.rlti.gestaoservicos.config.security.services.UserDetailsImpl;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Log4j2
public class AuthApplicationService implements AuthService {

    AuthenticationManager authenticationManager;
    RefreshTokenService refreshTokenService;
    JwtUtils jwtUtils;

    @Override
    public JwtResponse autentica(UsernamePasswordAuthenticationToken userPassToken) {
        log.info("[inicio] AuthApplicationService - autentica");
        Authentication authentication = authenticationManager.authenticate(userPassToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getId());
        log.info("[finaliza] AuthApplicationService - autentica");
        return new JwtResponse(jwt,userDetails, refreshToken.getToken());
    }

    @Override
    public TokenRefreshResponse reativaAutenticacao(TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();
        return refreshTokenService.findByToken(requestRefreshToken)
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUser)
                .map(user -> {
                    String token = jwtUtils.generateTokenFromUsername(user.getUsername());
                    return new TokenRefreshResponse(token, requestRefreshToken);
                })
                .orElseThrow(() -> new TokenRefreshException(requestRefreshToken, "Refresh token is not in database!"));
    }

    @Override
    public MessageResponse logoutUser() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UUID userId = userDetails.getId();
        refreshTokenService.deleteByUserId(userId);
        return new MessageResponse("Log out successful!");
    }
}
