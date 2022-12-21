package com.rlti.gestaoservicos.secretaria.application.api.secretaria;

import com.rlti.gestaoservicos.secretaria.application.service.secretaria.SecretariaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class SecretariaRestController implements SecretariaApi {

    private final SecretariaService secretariaService;

    @Override
    public SecretariaIdResponse postSecretaria(SecretariaRequest secretariaRequest) {
        log.info("[inicia] SecretariaRestController - postSecretaria");
        SecretariaIdResponse secretariaCriada = secretariaService.criaSecretaria(secretariaRequest);
        log.info("[finaliza] SecretariaRestController - postSecretaria");
        return secretariaCriada;
    }
}
