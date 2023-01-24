package com.rlti.gestaoservicos.ordemservicoexterna.infra;

import com.rlti.gestaoservicos.ordemservicoexterna.application.repository.OrdemServicoExternaRepository;
import com.rlti.gestaoservicos.ordemservicoexterna.domain.OrdemServicoExterna;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Log4j2
@RequiredArgsConstructor
@Repository
public class OrdemServicoExternaInfraRepository implements OrdemServicoExternaRepository {
    private  final OrdemServicoExternaSpringDataJpaRepository externaSpringDataJpaRepository;

    @Override
    public OrdemServicoExterna salva(OrdemServicoExterna ordemServicoExterna) {
        log.info("[inicia] OrdemServicoExternaInfraRepository - salva");
        externaSpringDataJpaRepository.save(ordemServicoExterna);
        log.info("[finaliza] OrdemServicoExternaInfraRepository - salva");
        return ordemServicoExterna;
    }
}
