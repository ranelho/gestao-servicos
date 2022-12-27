package com.rlti.gestaoservicos.suporte.application.service;

import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import com.rlti.gestaoservicos.suporte.application.api.SuporteAlteracaoRequest;
import com.rlti.gestaoservicos.suporte.application.api.SuporteIdResponse;
import com.rlti.gestaoservicos.suporte.application.api.SuporteListResponse;
import com.rlti.gestaoservicos.suporte.application.api.SuporteRequest;
import com.rlti.gestaoservicos.suporte.application.repository.SuporteRepository;
import com.rlti.gestaoservicos.suporte.domain.Suporte;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
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
    public Suporte buscaSuportePorId(Long idSuporte) {
        log.info("[inicia] SuporteApplicationService - buscaSuportePorId");
        Suporte suporte = suporteRepository.buscaSuportePorId(idSuporte);
        log.info("[finaliza] SuporteApplicationService - buscaSuportePorId");
        return suporte;
    }

    @Override
    public List<SuporteListResponse> getTodosSuportes() {
        log.info("[inicia] SuporteApplicationService - getTodasSecretarias");
        List<Suporte> listaSuporte = suporteRepository.getTodosSuportes();
        log.info("[finaliza] SuporteApplicationService - getTodasSecretarias");
        return SuporteListResponse.converte(listaSuporte);
    }

    @Override
    public void alteraSuporte(Long idSuporte, SuporteAlteracaoRequest suporteAlteracaoRequest) {
        log.info("[inicia] SuporteApplicationService - alteraSuporte");
        Suporte suporte = suporteRepository.buscaSuportePorId(idSuporte);
        suporte.altera(suporteAlteracaoRequest);
        suporteRepository.salva(suporte);
        log.info("[finaliza] SuporteApplicationService - alteraSuporte");
    }

    @Override
    public void deletaSuportePorId(Long idSuporte) {
        log.info("[inicia] SuporteApplicationService - deletaSuportePorId");
        buscaSuportePorId(idSuporte);
        suporteRepository.deleta(idSuporte);
        log.info("[finaliza] SuporteApplicationService - deletaSuportePorId");
    }
}
