package com.rlti.gestaoservicos.secretaria.application.api.secretaria;

import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Value
public class SecretariaRequest {
    @NotNull
    @Size(min = 3, max = 255)
    String secretaria;
    String secretario;
}