package com.rlti.gestaoservicos.secretaria.application.api.secretaria;

import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Value
public class SecretariaAlteracaoRequest {
    @NotNull
    @Size(message = "Campo secretaria não pode estar vazio", min = 3, max = 255)
    String secretaria;
    String secretario;
}
