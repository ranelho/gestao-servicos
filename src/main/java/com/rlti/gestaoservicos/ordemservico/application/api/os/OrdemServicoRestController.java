package com.rlti.gestaoservicos.ordemservico.application.api.os;

import com.rlti.gestaoservicos.ordemservico.application.service.os.OrdemServicoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class OrdemServicoRestController implements OrdemServicoApi {
    private final OrdemServicoService ordemServicoService;

  /*  @Override
    public OrdemServicoIdResponse postOS(OrdemServicoResquest ordemServicoResquest) {
        log.info("[inicia] OrdemServicoRestController - postOS");
        OrdemServicoIdResponse ordemServicoIdResponse = ordemServicoService.criaOS(ordemServicoResquest);
        log.info("[finaliza] OrdemServicoRestController - postOS");
        return ordemServicoIdResponse;
    }*/
}
