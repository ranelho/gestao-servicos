package com.rlti.gestaoservicos.ordemservicoexterna.application.api;


import com.rlti.gestaoservicos.ordemservicoexterna.application.service.OrdemServicoExternaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
}
