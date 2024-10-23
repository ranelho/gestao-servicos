package com.rlti.gestaoservicos.suporte.application.service;


import com.rlti.gestaoservicos.suporte.application.api.SuporteAlteracaoRequest;
import com.rlti.gestaoservicos.suporte.application.api.SuporteIdResponse;
import com.rlti.gestaoservicos.suporte.application.api.SuporteListResponse;
import com.rlti.gestaoservicos.suporte.application.api.SuporteRequest;
import com.rlti.gestaoservicos.suporte.application.repository.SuporteRepository;
import com.rlti.gestaoservicos.suporte.domain.Suporte;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class SuporteApplicationService implements SuporteService {
    private final SuporteRepository suporteRepository;

    @Override
    public SuporteIdResponse criaSuporte(SuporteRequest suporteRequest) {
        log.info("[inicia] SuporteApplicationService - criaSuporte");
        Suporte suporte = suporteRepository.salva(new Suporte(suporteRequest));
        log.info("[finaliza] SuporteApplicationService - criaSuporte");
        return SuporteIdResponse.builder().idSuporte(suporte.getIdSuporte()).build();
    }

    @Override
    public Suporte findSuporteById(Long idSuporte) {
        log.info("[inicia] SuporteApplicationService - findSuporteById");
        Suporte suporte = suporteRepository.findSuporteById(idSuporte);
        log.info("[finaliza] SuporteApplicationService - findSuporteById");
        return suporte;
    }

    @Override
    public List<SuporteListResponse> getAllSuportes() {
        log.info("[inicia] SuporteApplicationService - getAllSuportes");
        List<Suporte> listaSuporte = suporteRepository.getAllSuportes();
        log.info("[finaliza] SuporteApplicationService - getAllSuportes");
        return SuporteListResponse.converte(listaSuporte);
    }

    @Override
    public void alteraSuporte(Long idSuporte, SuporteAlteracaoRequest suporteAlteracaoRequest) {
        log.info("[inicia] SuporteApplicationService - alteraSuporte");
        Suporte suporte = suporteRepository.findSuporteById(idSuporte);
        suporte.altera(suporteAlteracaoRequest);
        suporteRepository.salva(suporte);
        log.info("[finaliza] SuporteApplicationService - alteraSuporte");
    }

    @Override
    public void deletaSuporteById(Long idSuporte) {
        log.info("[inicia] SuporteApplicationService - deletaSuporteById");
        findSuporteById(idSuporte);
        suporteRepository.deleta(idSuporte);
        log.info("[finaliza] SuporteApplicationService - deletaSuporteById");
    }
}
