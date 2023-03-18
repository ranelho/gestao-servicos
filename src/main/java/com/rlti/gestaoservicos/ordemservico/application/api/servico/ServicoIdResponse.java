package com.rlti.gestaoservicos.ordemservico.application.api.servico;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ServicoIdResponse {
    Long idServico;
}
