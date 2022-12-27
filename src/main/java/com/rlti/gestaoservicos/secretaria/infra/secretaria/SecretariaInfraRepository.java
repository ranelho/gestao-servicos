package com.rlti.gestaoservicos.secretaria.infra.secretaria;

import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.secretaria.application.repository.secretaria.SecretariaRepository;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
            throw APIException.build(HttpStatus.BAD_REQUEST, "Secretaria já cadastrada!", e);
        }
        log.info("[finaliza] SecretariaInfraRepository - salva");
        return secretaria;
    }

    @Override
    public Secretaria buscaSecretariaPorId(Long idSecretaria) {
        log.info("[inicia] SecretariaInfraRepository - buscaSecretariaPorId");
        Optional<Secretaria> optionalSecretaria = secretariaSpringDataJPARepository.findById(idSecretaria);
        Secretaria secretaria = optionalSecretaria.orElseThrow(
                () -> { throw APIException.build(HttpStatus.NOT_FOUND, "Secretaria inexistente!");  }
        );
        log.info("[finaliza] SecretariaInfraRepository - buscaSecretariaPorId");
        return secretaria;
    }

    @Override
    public List<Secretaria> getTodasSecretarias() {
        log.info("[inicia] SecretariaInfraRepository - SecretariaInfraRepository");
        List<Secretaria> listaSecretaria = secretariaSpringDataJPARepository.findAll();
        log.info("[finaliza] SecretariaInfraRepository - SecretariaInfraRepository");
        return listaSecretaria;
    }

    @Override
    public void deleta(Long idSecretaria) {
        log.info("[inicia] SecretariaInfraRepository - deleta");
        secretariaSpringDataJPARepository.deleteById(idSecretaria);
        log.info("[finaliza] SecretariaInfraRepository - deleta");
    }
}
