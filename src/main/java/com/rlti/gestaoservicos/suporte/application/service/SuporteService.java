package com.rlti.gestaoservicos.suporte.application.service;

import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoListResponse;
import com.rlti.gestaoservicos.suporte.application.api.SuporteAlteracaoRequest;
import com.rlti.gestaoservicos.suporte.application.api.SuporteIdResponse;
import com.rlti.gestaoservicos.suporte.application.api.SuporteListResponse;
import com.rlti.gestaoservicos.suporte.application.api.SuporteRequest;
import com.rlti.gestaoservicos.suporte.domain.Suporte;

import java.util.List;

public interface SuporteService {
    SuporteIdResponse criaSuporte(SuporteRequest suporteRequest);
    Suporte buscaSuportePorId(Long idSuporte);
    List<SuporteListResponse> getTodosSuportes();
    void alteraSuporte(Long idSuporte, SuporteAlteracaoRequest suporteAlteracaoRequest);
    void deletaSuportePorId(Long idSuporte);

}
