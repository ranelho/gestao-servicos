package com.rlti.gestaoservicos.ordemservico.application.api.os;

import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import com.rlti.gestaoservicos.suporte.domain.Suporte;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Value
public class OrdemServicoResquest {
    @NotNull
    private Equipamento equipamento;
    @NotNull
   // private List<Suporte> suportes;
    @Size(message = "Campo descrição não pode estar vazio", min = 3, max = 255)
    private String descricaoProblema;
    private String observacao;
}
