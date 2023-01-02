package com.rlti.gestaoservicos.ordemservico.application.api.servico;

import com.rlti.gestaoservicos.ordemservico.domain.Servico;
import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaListResponse;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class ServicoListResponse {
    private Long idServico;
    private LocalDate dataServico;
    private String servico;

    public static List<ServicoListResponse> converte(List<Servico> listaServico) {
        return listaServico.stream().map(ServicoListResponse::new).collect(Collectors.toList());
    }

    public ServicoListResponse(Servico servico) {
        this.idServico = servico.getIdServico();
        this.dataServico = servico.getDataServico();
        this.servico = servico.getServico();
    }
}
