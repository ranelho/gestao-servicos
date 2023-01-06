package com.rlti.gestaoservicos.ordemservico.application.api.os;

import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import com.rlti.gestaoservicos.ordemservico.application.api.servico.ServicoListResponse;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.ordemservico.domain.Servico;
import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class OrdemServicoListResponse {
    private Long idOrdemServico;
    private String equipamento;
    private LocalDateTime dataOrdemServico;
    private LocalDateTime dataFimOrdemServico;
    private Situacao situacao;

    public OrdemServicoListResponse(OrdemServico ordemServico) {
        this.idOrdemServico = ordemServico.getIdOrdemServico();
        this.equipamento = ordemServico.getEquipamento().getPatrimonio();
        this.dataOrdemServico = ordemServico.getDataOrdemServico();
        this.dataFimOrdemServico = ordemServico.getDataFimOrdemServico();
        this.situacao = ordemServico.getSituacao();
    }

    public static List<OrdemServicoListResponse> converte(List<OrdemServico> ordemServicoList) {
        return ordemServicoList.stream().map(OrdemServicoListResponse::new).collect(Collectors.toList());
    }

}
