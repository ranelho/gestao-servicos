package com.rlti.gestaoservicos.ordemservicoexterna.application.repository;

import com.rlti.gestaoservicos.ordemservicoexterna.domain.OrdemServicoExterna;

public interface OrdemServicoExternaRepository {
    OrdemServicoExterna salva(OrdemServicoExterna ordemServicoExterna);
}
