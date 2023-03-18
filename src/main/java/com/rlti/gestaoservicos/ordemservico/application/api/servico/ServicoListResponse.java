package com.rlti.gestaoservicos.ordemservico.application.api.servico;

import com.rlti.gestaoservicos.ordemservico.domain.Servico;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class ServicoListResponse {
    Long idServico;
    LocalDate dataServico;
    String descricaoServico;

    public static List<ServicoListResponse> converte(List<Servico> listaServico) {
        return listaServico.stream().map(ServicoListResponse::new).collect(Collectors.toList());
    }

    public ServicoListResponse(Servico servico) {
        this.idServico = servico.getIdServico();
        this.dataServico = servico.getDataServico();
        this.descricaoServico = servico.getDescricaoServico();
    }
}