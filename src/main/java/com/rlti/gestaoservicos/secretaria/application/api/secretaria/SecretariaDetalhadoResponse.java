package com.rlti.gestaoservicos.secretaria.application.api.secretaria;

import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import lombok.Value;

@Value
public class SecretariaDetalhadoResponse {
    private Long idSecretaria;
    private String secretaria;
    private String secretario;

    public SecretariaDetalhadoResponse(Secretaria secretaria) {
        this.idSecretaria = secretaria.getIdSecretaria();
        this.secretaria = secretaria.getSecretaria();
        this.secretario = secretaria.getSecretario();
    }
}



