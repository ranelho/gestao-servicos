package com.rlti.gestaoservicos.suporte.application.api;

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
    public SuporteDetalhadoResponse getSuporteById(Long idSuporte) {
        log.info("[inicia] SuporteRestController - getSuporteById");
        Suporte suporte = suporteService.findSuporteById(idSuporte);
        log.info("[finaliza] SuporteRestController - getSuporteById");
        return new SuporteDetalhadoResponse(suporte);
    }

    @Override
    public List<SuporteListResponse> getAllSuportes() {
        log.info("[inicia] SuporteRestController - getAllSuportes");
        List<SuporteListResponse> listaSuporte = suporteService.getAllSuportes();
        log.info("[finaliza] SuporteRestController - getAllSuportes");
        return listaSuporte;
    }

    @Override
    public void alteraSuporte(Long idSuporte,  SuporteAlteracaoRequest suporteAlteracaoRequest) {
        log.info("[inicia] SuporteRestController - alteraSuporte");
        suporteService.alteraSuporte(idSuporte, suporteAlteracaoRequest);
        log.info("[finaliza] SuporteRestController - alteraSuporte");
    }

    @Override
    public void deletaSuporteById(Long idSuporte) {
        log.info("[inicia] SuporteRestController - deletaSuporteById");
        suporteService.deletaSuporteById(idSuporte);
        log.info("[finaliza] SuporteRestController - deletaSuporteById");
    }

    @Override
    public SuporteOSListResponse getOSSuporteById(Long idSuporte) {
        log.info("[inicia] SuporteRestController - getOSSuporteById");
        Suporte suporte = suporteService.findSuporteById(idSuporte);
        log.info("[finaliza] SuporteRestController - getOSSuporteById");
        return new SuporteOSListResponse(suporte);
    }
}
