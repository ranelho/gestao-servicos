package com.rlti.gestaoservicos.autenticacao.application.api;


import com.rlti.gestaoservicos.autenticacao.application.api.request.LoginRequest;
import com.rlti.gestaoservicos.autenticacao.application.api.request.TokenRefreshRequest;
import com.rlti.gestaoservicos.autenticacao.application.api.response.JwtResponse;
import com.rlti.gestaoservicos.autenticacao.application.api.response.MessageResponse;
import com.rlti.gestaoservicos.autenticacao.application.api.response.TokenRefreshResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public interface AuthApi {

    @PostMapping("/signin")
    JwtResponse autentica(@RequestBody @Valid LoginRequest loginRequest) throws AuthenticationException;

    @PostMapping("/refreshToken")
    TokenRefreshResponse reativaAutenticacao(@Valid @RequestBody TokenRefreshRequest request) ;

    @PostMapping("/signout")
    MessageResponse logoutUser();
}
