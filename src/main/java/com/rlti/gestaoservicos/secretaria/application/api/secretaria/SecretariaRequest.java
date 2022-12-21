package com.rlti.gestaoservicos.secretaria.application.api.secretaria;

import com.rlti.gestaoservicos.secretaria.domain.Setor;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Value
public class SecretariaRequest {
    private Long idSecretaria;
    @NotNull
    @Size(message = "Campo secretaria não pode estar vazio", min = 3, max = 255)
    private String secretaria;
    private String secretario;
    private Set<Setor> setores;
}
