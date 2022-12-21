package com.rlti.gestaoservicos.secretaria.infra.setor;

import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.secretaria.application.repository.setor.SetorRepository;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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

    @Override
    public Optional<Setor> buscaSetorPorId(Long idSetor) {
        log.info("[inicia] SetorInfraRespository - buscaSetorPorId");
        Optional<Setor> setor = setorSpringDataJPARepository.findById(idSetor);
        log.info("[finaliza] SetorInfraRespository - buscaSetorPorId");
        return setor;
    }
}
