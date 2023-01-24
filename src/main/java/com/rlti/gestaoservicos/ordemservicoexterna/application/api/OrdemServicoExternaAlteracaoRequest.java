package com.rlti.gestaoservicos.ordemservicoexterna.application.api;

import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import com.rlti.gestaoservicos.suporte.domain.Suporte;
import lombok.Value;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Value
public class OrdemServicoExternaAlteracaoRequest {
    private LocalDateTime dataFimOrdemServico;
    private List<Suporte> suportes;
    private Situacao situacao;
    @Size(message = "Campo serviço não pode estar vazio", min = 3, max = 255)
    private String descricaoProblema;
    private String observacao;
    private String diagnostico;
}
