package com.rlti.gestaoservicos.ordemservicoexterna.application.service;

import com.rlti.gestaoservicos.ordemservicoexterna.application.api.OrdemServicoExternaIdResponse;
import com.rlti.gestaoservicos.ordemservicoexterna.application.api.OrdemServicoExternaResquest;
import com.rlti.gestaoservicos.ordemservicoexterna.application.repository.OrdemServicoExternaRepository;
import com.rlti.gestaoservicos.ordemservicoexterna.domain.OrdemServicoExterna;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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
}