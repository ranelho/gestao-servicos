package com.rlti.gestaoservicos.relatorios.application.api;

import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import lombok.Value;

@Value
public class SituacaoRequest {
    Situacao situacao;
}
