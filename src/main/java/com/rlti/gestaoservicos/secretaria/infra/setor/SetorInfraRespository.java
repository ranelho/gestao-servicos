package com.rlti.gestaoservicos.secretaria.infra.setor;

import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.secretaria.application.repository.setor.SetorRepository;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import com.rlti.gestaoservicos.secretaria.infra.secretaria.SecretariaSpringDataJPARepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class SetorInfraRespository implements SetorRepository {
    private final SetorSpringDataJPARepository setorSpringDataJPARepository;

    @Override
    public Setor salva(Setor setor) {
        log.info("[inicia] SetorInfraRespository - salva");
        try{
            Setor setorSalvo = setorSpringDataJPARepository.save(setor);
            log.info("[finaliza] SetorInfraRespository - salva");
            return setorSalvo;
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST, "Setor já cadastrada!", e);
        }
    }
}
