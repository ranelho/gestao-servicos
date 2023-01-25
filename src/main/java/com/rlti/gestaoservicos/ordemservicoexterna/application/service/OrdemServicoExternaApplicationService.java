package com.rlti.gestaoservicos.ordemservicoexterna.application.service;

import com.rlti.gestaoservicos.ordemservicoexterna.application.api.OrdemServicoExternaIdResponse;
import com.rlti.gestaoservicos.ordemservicoexterna.application.api.OrdemServicoExternaListResponse;
import com.rlti.gestaoservicos.ordemservicoexterna.application.api.OrdemServicoExternaResquest;
import com.rlti.gestaoservicos.ordemservicoexterna.application.repository.OrdemServicoExternaRepository;
import com.rlti.gestaoservicos.ordemservicoexterna.domain.OrdemServicoExterna;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class OrdemServicoExternaApplicationService implements OrdemServicoExternaService {
    private final OrdemServicoExternaRepository ordemServicoExternaRepository;

    @Override
    public OrdemServicoExternaIdResponse criaOsExterna(OrdemServicoExternaResquest externaResquest) {
        log.info("[inicia] OrdemServicoExternaApplicationService - criaOsExterna");
        OrdemServicoExterna ordemServicoExterna = ordemServicoExternaRepository.salva(new OrdemServicoExterna(externaResquest));
        log.info("[finaliza] OrdemServicoExternaApplicationService - criaOsExterna");
        return OrdemServicoExternaIdResponse.builder().idOrdemServicoExterna(ordemServicoExterna.getIdOrdemServicoExterna()).build();
    }

    @Override
    public OrdemServicoExterna getOSExternaById(UUID idOrdemServicoExterna) {
        log.info("[inicia] OrdemServicoExternaApplicationService - getOSExternaById");
        OrdemServicoExterna ordemServicoExterna = ordemServicoExternaRepository.getOSExternaById(idOrdemServicoExterna);
        log.info("[finaliza] OrdemServicoExternaApplicationService - getOSExternaById");
        return ordemServicoExterna;
    }

    @Override
    public List<OrdemServicoExternaListResponse> getAllOSExterna() {
        log.info("[inicia] OrdemServicoExternaApplicationService - getAllOSExterna");
        List<OrdemServicoExterna> externaList = ordemServicoExternaRepository.getAllOSExterna();
        log.info("[finaliza] OrdemServicoExternaApplicationService - getAllOSExterna");
        return OrdemServicoExternaListResponse.converte(externaList);
    }
}
