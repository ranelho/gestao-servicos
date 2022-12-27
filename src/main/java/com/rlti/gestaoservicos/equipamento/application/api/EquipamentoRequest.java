package com.rlti.gestaoservicos.equipamento.application.api;

import com.rlti.gestaoservicos.equipamento.domain.TipoEquipamento;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Value
public class EquipamentoRequest {
    @NotNull
    @Size(message = "Campo detalhes não pode estar vazio", max = 6, min = 6)
    private String patrimonio;
    @NotNull
    private TipoEquipamento tipoEquipamento;
    private String numeroSerie;
    @NotNull
    private Setor setor;
    private String modelo;
    private String marca;
    @Size(message = "Campo detalhes não pode estar vazio", max = 255, min = 3)
    private String detalhes;
}
