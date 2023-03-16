package com.rlti.gestaoservicos.suporte.application.api;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class SuporteRequest {
    @NotBlank
    String nome;
    String empresa;
}