package com.rlti.gestaoservicos.autenticacao.application.service;

import com.rlti.gestaoservicos.autenticacao.application.api.request.TokenRefreshRequest;
import com.rlti.gestaoservicos.autenticacao.application.api.response.JwtResponse;
import com.rlti.gestaoservicos.autenticacao.application.api.response.MessageResponse;
import com.rlti.gestaoservicos.autenticacao.application.api.response.TokenRefreshResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public interface AuthService {
    JwtResponse autentica(UsernamePasswordAuthenticationToken userPassToken);
    TokenRefreshResponse reativaAutenticacao(TokenRefreshRequest request);
    MessageResponse logoutUser();
}
