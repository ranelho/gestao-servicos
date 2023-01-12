package com.rlti.gestaoservicos.suporte.application.api;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class SuporteRequest {
    @NotBlank
    private String nome;
    private String empresa;
}

