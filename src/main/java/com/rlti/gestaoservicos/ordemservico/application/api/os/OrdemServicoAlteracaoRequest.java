package com.rlti.gestaoservicos.ordemservico.application.api.os;

import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import com.rlti.gestaoservicos.suporte.domain.Suporte;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Value
public class OrdemServicoAlteracaoRequest {
    LocalDate dataFinal;
    List<Suporte> suportes;
    @NotNull
    Situacao situacao;
    @NotNull
    @Size(message = "Campo serviço não pode estar vazio", min = 3, max = 255)
    String descricaoProblema;
    String observacao;
    String diagnostico;
}
