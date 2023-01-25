package com.rlti.gestaoservicos.ordemservicoexterna.application.service;

import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoAlteracaoRequest;
import com.rlti.gestaoservicos.ordemservicoexterna.application.api.OrdemServicoExternaIdResponse;
import com.rlti.gestaoservicos.ordemservicoexterna.application.api.OrdemServicoExternaListResponse;
import com.rlti.gestaoservicos.ordemservicoexterna.application.api.OrdemServicoExternaResquest;
import com.rlti.gestaoservicos.ordemservicoexterna.domain.OrdemServicoExterna;

import java.util.List;
import java.util.UUID;

public interface OrdemServicoExternaService {
    OrdemServicoExternaIdResponse criaOsExterna(OrdemServicoExternaResquest externaResquest);
    OrdemServicoExterna getOSExternaById(UUID idOrdemServicoExterna);
    List<OrdemServicoExternaListResponse> getAllOSExterna();
    List<OrdemServicoExternaListResponse> getAtendimentos();
    void alteraOSExterna(UUID idOrdemServicoExterna, OrdemServicoAlteracaoRequest ordemServicoAlteracaoRequest);
    void deletaOSExternaById(UUID idOrdemServicoExterna);
}
