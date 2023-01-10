package com.rlti.gestaoservicos.suporte.application.api;

import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoListResponse;
import com.rlti.gestaoservicos.suporte.application.service.SuporteService;
import com.rlti.gestaoservicos.suporte.domain.Suporte;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class SuporteRestController implements SuporteApi {
    private final SuporteService suporteService;

    @Override
    public SuporteIdResponse postSuporte(SuporteRequest suporteRequest) {
        log.info("[inicia] SuporteRestController - postSuporte");
        SuporteIdResponse suporteIdResponse = suporteService.criaSuporte(suporteRequest);
        log.info("[finaliza] SuporteRestController - postSuporte");
        return suporteIdResponse;
    }
    @Override
    public SuporteDetalhadoResponse getSuportePorId(Long idSuporte) {
        log.info("[inicia] SuporteRestController - getSuportePorId");
        Suporte suporte = suporteService.buscaSuportePorId(idSuporte);
        log.info("[finaliza] SuporteRestController - getSuportePorId");
        return new SuporteDetalhadoResponse(suporte);
    }

    @Override
    public List<SuporteListResponse> getTodosSuportes() {
        log.info("[inicia] SuporteRestController - getTodosSuportes");
        List<SuporteListResponse> listaSuporte = suporteService.getTodosSuportes();
        log.info("[finaliza] SuporteRestController - getTodosSuportes");
        return listaSuporte;
    }

    @Override
    public void alteraSuporte(Long idSuporte,  SuporteAlteracaoRequest suporteAlteracaoRequest) {
        log.info("[inicia] SuporteRestController - alteraSuporte");
        suporteService.alteraSuporte(idSuporte, suporteAlteracaoRequest);
        log.info("[finaliza] SuporteRestController - alteraSuporte");
    }

    @Override
    public void deletaSuportePorId(Long idSuporte) {
        log.info("[inicia] SuporteRestController - deletaSuportePorId");
        suporteService.deletaSuportePorId(idSuporte);
        log.info("[finaliza] SuporteRestController - deletaSuportePorId");
    }
}
