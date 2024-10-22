package com.rlti.gestaoservicos.print.api;

import com.rlti.gestaoservicos.ordemservico.domain.Servico;
import lombok.Data;

import java.util.List;

import static com.rlti.gestaoservicos.util.Utils.formatarData;

@Data
public class ServicoPrintResponse {
    private String dataServico;
    private String descricaoServico;

    public ServicoPrintResponse(Servico servico) {
        this.dataServico = formatarData(servico.getDataServico());
        this.descricaoServico = servico.getDescricaoServico();
    }

    public static List<ServicoPrintResponse> converte(List<Servico> servicos) {
        return servicos.stream()
                .map(ServicoPrintResponse::new)
                .toList();
    }
}
