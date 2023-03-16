package com.rlti.gestaoservicos.secretaria.application.api.secretaria;

import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import lombok.Value;

@Value
public class SecretariaDetalhadoResponse {
    Long idSecretaria;
    String secretaria;
    String secretario;

    public SecretariaDetalhadoResponse(Secretaria secretaria) {
        this.idSecretaria = secretaria.getIdSecretaria();
        this.secretaria = secretaria.getSecretaria();
        this.secretario = secretaria.getSecretario();
    }
}