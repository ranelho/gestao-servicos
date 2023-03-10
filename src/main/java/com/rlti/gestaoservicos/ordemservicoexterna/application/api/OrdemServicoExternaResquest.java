package com.rlti.gestaoservicos.ordemservicoexterna.application.api;

import com.rlti.gestaoservicos.secretaria.domain.Setor;
import com.rlti.gestaoservicos.suporte.domain.Suporte;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Value
public class OrdemServicoExternaResquest {
    @NotNull
    private Setor setor;
    @NotNull
    private List<Suporte> suportes;
    @Size(message = "Campo descrição não pode estar vazio", min = 3, max = 255)
    private String descricaoProblema;
    private String observacao;
}
