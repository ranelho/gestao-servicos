package com.rlti.gestaoservicos.ordemservico.application.api.os;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class OrdemServicoIdResponse {
    UUID protocolo;
}
