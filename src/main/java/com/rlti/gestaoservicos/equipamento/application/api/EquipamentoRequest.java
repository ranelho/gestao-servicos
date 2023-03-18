package com.rlti.gestaoservicos.equipamento.application.api;

import com.rlti.gestaoservicos.equipamento.domain.TipoEquipamento;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Value
public class EquipamentoRequest {
    @NotBlank
    @Size(max = 6, min = 6, message = "o patrimônio tem que ter 6 caracteres")
    String patrimonio;
    @NotNull
    TipoEquipamento tipoEquipamento;
    String numeroSerie;
    Setor setor;
    String modelo;
    String marca;
    @Size(message = "Campo detalhes não pode estar vazio", max = 255, min = 3)
    String detalhes;
}