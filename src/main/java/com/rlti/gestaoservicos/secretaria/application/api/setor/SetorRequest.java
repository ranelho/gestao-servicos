package com.rlti.gestaoservicos.secretaria.application.api.setor;

import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class SetorRequest {
    @NotBlank
    private String setor;
    @NotBlank
    private Secretaria secretaria;
    private String responsavel;
}
