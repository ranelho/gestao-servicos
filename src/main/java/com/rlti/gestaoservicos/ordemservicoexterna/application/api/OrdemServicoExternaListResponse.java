package com.rlti.gestaoservicos.ordemservicoexterna.application.api;

import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import com.rlti.gestaoservicos.ordemservicoexterna.domain.OrdemServicoExterna;
import com.rlti.gestaoservicos.secretaria.application.api.setor.SetorListResponse;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class OrdemServicoExternaListResponse {
    private UUID idOrdemServicoExterna;
    private String setor;
    private LocalDateTime dataOrdemServico;
    private LocalDateTime dataFimOrdemServico;
    private Situacao situacao;
    private String diagnostico;

    public OrdemServicoExternaListResponse(OrdemServicoExterna ordemServicoExterna) {
        this.idOrdemServicoExterna = ordemServicoExterna.getIdOrdemServicoExterna();
        this.setor = ordemServicoExterna.getSetor().getSetor();
        this.dataOrdemServico = ordemServicoExterna.getDataOrdemServico();
        this.dataFimOrdemServico = ordemServicoExterna.getDataFimOrdemServico();
        this.situacao = ordemServicoExterna.getSituacao();
        this.diagnostico = ordemServicoExterna.getDiagnostico();
    }

    public static List<OrdemServicoExternaListResponse> converte(List<OrdemServicoExterna> ordemServicoList) {
        return ordemServicoList.stream().map(OrdemServicoExternaListResponse::new).collect(Collectors.toList());
    }

}
