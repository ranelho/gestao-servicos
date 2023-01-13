package com.rlti.gestaoservicos.secretaria.application.api.setor;

import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Value
public class SetorRequest {
    @NotNull
    private String setor;
    private Secretaria secretaria;
    private String responsavel;
}
