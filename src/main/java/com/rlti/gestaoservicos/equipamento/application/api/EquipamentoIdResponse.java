package com.rlti.gestaoservicos.equipamento.application.api;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EquipamentoIdResponse {
    private Long idEquipamento;
}
