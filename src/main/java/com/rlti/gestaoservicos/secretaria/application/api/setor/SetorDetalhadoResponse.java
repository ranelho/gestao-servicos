package com.rlti.gestaoservicos.secretaria.application.api.setor;

import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import lombok.Value;

@Value
public class SetorDetalhadoResponse {
    private String setor;
    private String responsavel;

    public SetorDetalhadoResponse(Setor setor) {
        this.setor = setor.getSetor();
        this.responsavel = setor.getResponsavel();
    }
}
