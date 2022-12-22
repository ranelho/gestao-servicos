package com.rlti.gestaoservicos.secretaria.application.api.setor;

import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import lombok.Value;

@Value
public class SetorRequest {
    private String setor;
    private Secretaria secretaria;
    private String responsavel;
}
