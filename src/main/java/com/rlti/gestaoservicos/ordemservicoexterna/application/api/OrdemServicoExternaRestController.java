package com.rlti.gestaoservicos.ordemservicoexterna.application.api;


import com.rlti.gestaoservicos.ordemservicoexterna.application.service.OrdemServicoExternaService;
import com.rlti.gestaoservicos.ordemservicoexterna.domain.OrdemServicoExterna;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class OrdemServicoExternaRestController implements OrdemServicoExternaApi {
    private final OrdemServicoExternaService ordemServicoExternaService;
    
    @Override
    public OrdemServicoExternaIdResponse postOsExterna(OrdemServicoExternaResquest externaResquest) {
        log.info("[inicia] OrdemServicoExternaRestController - postOsExterna");
        OrdemServicoExternaIdResponse ordemServicoExternaIdResponse = ordemServicoExternaService.criaOsExterna(externaResquest);
        log.info("[finaliza] OrdemServicoExternaRestController - postOsExterna");
        return ordemServicoExternaIdResponse;
    }

    @Override
    public OrdemServicoExternaResponse getOSExternaById(UUID idOrdemServicoExterna) {
        log.info("[inicia] OrdemServicoExternaRestController - getOSExternaById");
        OrdemServicoExterna ordemServicoExterna = ordemServicoExternaService. getOSExternaById(idOrdemServicoExterna);
        log.info("[finaliza] OrdemServicoExternaRestController - getOSExternaById");
        return new OrdemServicoExternaResponse(ordemServicoExterna);
    }

    @Override
    public List<OrdemServicoExternaListResponse> getAllOSExterna() {
        log.info("[inicia] OrdemServicoExternaRestController - getAllOSExterna");
        List<OrdemServicoExternaListResponse> listResponses = ordemServicoExternaService.getAllOSExterna();
        log.info("[finaliza] OrdemServicoExternaRestController - getAllOSExterna");
        return listResponses;
    }
}
