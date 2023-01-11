package com.rlti.gestaoservicos.secretaria.application.api.secretaria;

import com.rlti.gestaoservicos.secretaria.application.service.secretaria.SecretariaService;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @Override
    public SecretariaDetalhadoResponse getSecretariaById(Long idSecretaria) {
        log.info("[inicia] SecretariaRestController - getSecretariaById");
        Secretaria secretaria = secretariaService.findSecretariaById(idSecretaria);
        log.info("[finaliza] SecretariaRestController - getSecretariaById");
        return new SecretariaDetalhadoResponse(secretaria);
    }

    @Override
    public List<SecretariaListResponse> getAllSecretarias() {
        log.info("[inicia] SecretariaRestController - getAllSecretarias");
        List<SecretariaListResponse> listaSecretarias = secretariaService.getAllSecretarias();
        log.info("[finaliza] SecretariaRestController - getAllSecretarias");
        return listaSecretarias;
    }

    @Override
    public void alteraSecretaria(Long idSecretaria,  SecretariaAlteracaoRequest secretariaAlteracaoRequest) {
        log.info("[inicia] SecretariaRestController - alteraSecretaria");
        secretariaService.alteraSecretaria(idSecretaria, secretariaAlteracaoRequest);
        log.info("[finaliza] SecretariaRestController - alteraSecretaria");
    }

    @Override
    public void deletaSecretariaById(Long idSecretaria) {
        log.info("[inicia] SecretariaRestController - deletaSecretariaById");
        secretariaService.deletaSecretariaById(idSecretaria);
        log.info("[finaliza] SecretariaRestController - deletaSecretariaById");
    }
}
