package com.rlti.gestaoservicos.ordemservicoexterna.infra;

import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.ordemservicoexterna.application.repository.OrdemServicoExternaRepository;
import com.rlti.gestaoservicos.ordemservicoexterna.domain.OrdemServicoExterna;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public OrdemServicoExterna getOSExternaById(UUID idOrdemServicoExterna) {
        log.info("[inicia] OrdemServicoExternaInfraRepository - getOSExternaById");
        Optional<OrdemServicoExterna> optionalOrdemServicoExterna = externaSpringDataJpaRepository.findById(idOrdemServicoExterna);
        OrdemServicoExterna ordemServicoExterna = optionalOrdemServicoExterna
                .orElseThrow(() -> {
                    throw APIException.build(HttpStatus.NOT_FOUND, "Ordem de Serviço não encontrada");
                });
        log.info("[finaliza] OrdemServicoExternaInfraRepository - getOSExternaById");
        return ordemServicoExterna;
    }

    @Override
    public List<OrdemServicoExterna> getAllOSExterna() {
        log.info("[inicia] OrdemServicoExternaInfraRepository - getAllOSExterna");
        List<OrdemServicoExterna> externaList = externaSpringDataJpaRepository.findAll();
        log.info("[finaliza] OrdemServicoExternaInfraRepository - getAllOSExterna");
        return externaList;
    }

    @Override
    public List<OrdemServicoExterna> getAtendimentos() {
        log.info("[inicia] OrdemServicoExternaInfraRepository - getAllOSExterna");
        List<OrdemServicoExterna> externaList = externaSpringDataJpaRepository.findAllAtendimentos();
        log.info("[finaliza] OrdemServicoExternaInfraRepository - getAllOSExterna");
        return externaList;
    }
}
