package com.rlti.gestaoservicos.secretaria.infra.secretaria;

import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaRequest;
import com.rlti.gestaoservicos.secretaria.application.repository.secretaria.SecretariaRepository;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class SecretariaInfraRepository implements SecretariaRepository {
    private final SecretariaSpringDataJPARepository secretariaSpringDataJPARepository;
       @Override
    public Secretaria salva(Secretaria secretaria) {
        log.info("[inicia] SecretariaInfraRepository - salva");
        try {
            secretariaSpringDataJPARepository.save(secretaria);
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Secretaria já cadastrada!");
        }
        log.info("[finaliza] SecretariaInfraRepository - salva");
        return secretaria;
    }
}
