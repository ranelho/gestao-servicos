package com.rlti.gestaoservicos.ordemservico.application.api.servico;

import com.rlti.gestaoservicos.ordemservico.domain.Servico;
import lombok.Value;

import java.time.LocalDate;

@Value
public class ServicoDetalhadoResponse {
    Long idServico;
    LocalDate dataServico;
    String descricaoServico;

    public ServicoDetalhadoResponse(Servico servico) {
        this.idServico = servico.getIdServico();
        this.dataServico = servico.getDataServico();
        this.descricaoServico = servico.getDescricaoServico();
    }
}
