package com.rlti.gestaoservicos.ordemservicoexterna.application.service;

import com.rlti.gestaoservicos.ordemservicoexterna.application.api.OrdemServicoExternaIdResponse;
import com.rlti.gestaoservicos.ordemservicoexterna.application.api.OrdemServicoExternaResquest;
import com.rlti.gestaoservicos.ordemservicoexterna.domain.OrdemServicoExterna;

import java.util.UUID;

public interface OrdemServicoExternaService {
    OrdemServicoExternaIdResponse criaOsExterna(OrdemServicoExternaResquest externaResquest);
    OrdemServicoExterna getOSExternaById(UUID idOrdemServicoExterna);
}
