package com.rlti.gestaoservicos.ordemservicoexterna.application.service;

import com.rlti.gestaoservicos.ordemservicoexterna.application.api.OrdemServicoExternaIdResponse;
import com.rlti.gestaoservicos.ordemservicoexterna.application.api.OrdemServicoExternaResquest;

public interface OrdemServicoExternaService {
    OrdemServicoExternaIdResponse criaOsExterna(OrdemServicoExternaResquest externaResquest);
}
