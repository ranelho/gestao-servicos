package com.rlti.gestaoservicos.secretaria.application.service.secretaria;

import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaIdResponse;
import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaRequest;
import com.rlti.gestaoservicos.secretaria.application.repository.secretaria.SecretariaRepository;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}
