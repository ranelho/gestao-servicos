package com.rlti.gestaoservicos.secretaria.application.api.setor;

import lombok.Value;

@Value
public class SetorAlteracaoRequest {
    private String setor;
    private String responsavel;
}
