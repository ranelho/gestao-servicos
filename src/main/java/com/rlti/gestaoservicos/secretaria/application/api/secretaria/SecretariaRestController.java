package com.rlti.gestaoservicos.secretaria.application.api.secretaria;

import com.rlti.gestaoservicos.secretaria.application.service.secretaria.SecretariaService;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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
    public SecretariaDetalhadoResponse getSecretariaPorId(Long idSecretaria) {
        log.info("[inicia] SecretariaRestController - getSecretariaPorId");
        Secretaria secretaria = secretariaService.buscaSecretariaPorId(idSecretaria);
        log.info("[finaliza] SecretariaRestController - getSecretariaPorId");
        return new SecretariaDetalhadoResponse(secretaria);
    }

    @Override
    public List<SecretariaListResponse> getTodasSecretarias() {
        log.info("[inicia] SecretariaRestController - getTodasSecretarias");
        List<SecretariaListResponse> listaSecretarias = secretariaService.getTodasSecretarias();
        log.info("[finaliza] SecretariaRestController - getTodasSecretarias");
        return listaSecretarias;
    }

    @Override
    public void alteraSecretaria(Long idSecretaria,  SecretariaAlteracaoRequest secretariaAlteracaoRequest) {
        log.info("[inicia] SecretariaRestController - alteraSecretaria");
        secretariaService.alteraSecretaria(idSecretaria, secretariaAlteracaoRequest);
        log.info("[finaliza] SecretariaRestController - alteraSecretaria");
    }

    @Override
    public void deletaSecretariaPorId(Long idSecretaria) {
        log.info("[inicia] SecretariaRestController - deletaSecretariaPorId");
        secretariaService.deletaSecretariaPorId(idSecretaria);
        log.info("[finaliza] SecretariaRestController - deletaSecretariaPorId");
    }
}
