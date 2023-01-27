package com.rlti.gestaoservicos.ordemservicoexterna.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class OrdemServicoExternaIdResponse {
    private UUID idOrdemServicoExterna;
}
