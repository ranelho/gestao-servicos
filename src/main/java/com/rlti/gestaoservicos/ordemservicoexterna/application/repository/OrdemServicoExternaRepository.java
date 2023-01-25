package com.rlti.gestaoservicos.ordemservicoexterna.application.repository;

import com.rlti.gestaoservicos.ordemservicoexterna.domain.OrdemServicoExterna;

import java.util.List;
import java.util.UUID;

public interface OrdemServicoExternaRepository {
    OrdemServicoExterna salva(OrdemServicoExterna ordemServicoExterna);
    OrdemServicoExterna getOSExternaById(UUID idOrdemServicoExterna);
    List<OrdemServicoExterna> getAllOSExterna();
    List<OrdemServicoExterna> getAtendimentos();
}
