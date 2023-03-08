package com.rlti.gestaoservicos.usuario.application.api;

import com.rlti.gestaoservicos.usuario.application.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class UsuarioRestController implements UsuarioApi {

    private final UsuarioService usuarioService;

    @Override
    public UsuarioResponse postUsuario(UsuarioRequest usuarioRequest) {
        log.info("[inicia] UsuarioRestController - postUsuario");
        UsuarioResponse usuario = usuarioService.novoUsuario(usuarioRequest);
        log.info("[finaliza] UsuarioRestController - postUsuario");
        return usuario;
    }
}
