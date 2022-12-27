package com.rlti.gestaoservicos.secretaria.application.service.secretaria;

import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaAlteracaoRequest;
import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaIdResponse;
import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaListResponse;
import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaRequest;
import com.rlti.gestaoservicos.secretaria.application.repository.secretaria.SecretariaRepository;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class SecretariaApplicationService implements SecretariaService {
    private final SecretariaRepository secretariaRepository;

    @Override
    public SecretariaIdResponse criaSecretaria(SecretariaRequest secretariaRequest) {
        log.info("[inicia] SecretariaApplicationService - CriaSecretaria");
        Secretaria secretaria = secretariaRepository.salva(new Secretaria(secretariaRequest));
        log.info("[finaliza] SecretariaApplicationService - CriaSecretaria");
        return SecretariaIdResponse.builder().idSecretaria(secretaria.getIdSecretaria()).build();
    }
    @Override
    public Secretaria buscaSecretariaPorId(Long idSecretaria) {
       log.info("[inicia] SecretariaApplicationService - buscaSecretariaPorId");
       Secretaria secretaria = secretariaRepository.buscaSecretariaPorId(idSecretaria);
        log.info("[finaliza] SecretariaApplicationService - buscaSecretariaPorId");
        return secretaria;
    }

    @Override
    public List<SecretariaListResponse> getTodasSecretarias() {
        log.info("[inicia] SecretariaApplicationService - getTodasSecretarias");
        List<Secretaria> listaSecretaria = secretariaRepository.getTodasSecretarias();
        log.info("[finaliza] SecretariaApplicationService - getTodasSecretarias");
        return SecretariaListResponse.converte(listaSecretaria);

    }

    @Override
    public void alteraSecretaria(Long idSecretaria, SecretariaAlteracaoRequest secretariaAlteracaoRequest) {
        log.info("[inicia] SecretariaRestController - alteraSecretaria");
        Secretaria secretaria = secretariaRepository.buscaSecretariaPorId(idSecretaria);
        secretaria.altera(secretariaAlteracaoRequest);
        secretariaRepository.salva(secretaria);
        log.info("[finaliza] SecretariaRestController - alteraSecretaria");
    }

    @Override
    public void deletaSecretariaPorId(Long idSecretaria) {
        log.info("[inicia] SecretariaRestController - deletaSecretariaPorId");
        buscaSecretariaPorId(idSecretaria);
        secretariaRepository.deleta(idSecretaria);
        log.info("[finaliza] SecretariaRestController - deletaSecretariaPorId");
    }
}
