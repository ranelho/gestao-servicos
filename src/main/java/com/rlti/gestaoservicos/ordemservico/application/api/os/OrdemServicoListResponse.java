package com.rlti.gestaoservicos.ordemservico.application.api.os;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class OrdemServicoListResponse {
    private UUID idOrdemServico;
    private String equipamento;
    private LocalDateTime dataOrdemServico;
    private LocalDateTime dataFimOrdemServico;
    private Situacao situacao;
    private String diagnostico;

    public OrdemServicoListResponse(OrdemServico ordemServico) {
        this.idOrdemServico = ordemServico.getIdOrdemServico();
        this.equipamento = ordemServico.getEquipamento().getPatrimonio();
        this.dataOrdemServico = ordemServico.getDataOrdemServico();
        this.dataFimOrdemServico = ordemServico.getDataFimOrdemServico();
        this.situacao = ordemServico.getSituacao();
        this.diagnostico = ordemServico.getDiagnostico();
    }

    public static List<OrdemServicoListResponse> converte(List<OrdemServico> ordemServicoList) {
        return ordemServicoList.stream().map(OrdemServicoListResponse::new).collect(Collectors.toList());
    }

}
