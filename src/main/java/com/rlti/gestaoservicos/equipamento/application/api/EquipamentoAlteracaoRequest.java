package com.rlti.gestaoservicos.equipamento.application.api;

import com.rlti.gestaoservicos.equipamento.domain.TipoEquipamento;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Value
public class EquipamentoAlteracaoRequest {
    @NotNull
    String patrimonio;
    @NotNull
    TipoEquipamento tipoEquipamento;
    String numeroSerie;
    String modelo;
    String marca;
    @Size(message = "Campo detalhes não pode estar vazio", max = 255, min = 3)
    String detalhes;
}
