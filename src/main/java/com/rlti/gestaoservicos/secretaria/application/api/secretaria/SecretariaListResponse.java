package com.rlti.gestaoservicos.secretaria.application.api.secretaria;

import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class SecretariaListResponse {
    Long idSecretaria;
    String secretaria;
    String secretario;

    public static List<SecretariaListResponse> converte(List<Secretaria> listaSecretaria) {
        return listaSecretaria.stream().map(SecretariaListResponse::new).collect(Collectors.toList());
    }

    public SecretariaListResponse(Secretaria secretaria) {
        this.idSecretaria = secretaria.getIdSecretaria();
        this.secretaria = secretaria.getSecretaria();
        this.secretario = secretaria.getSecretario();
    }
}