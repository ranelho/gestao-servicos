package com.rlti.gestaoservicos.relatorios.application.api.response;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class HistoricoEquipamentoResponse {

    private UUID protocolo;
    private String equipamento;
    private LocalDateTime dataOrdemServico;
    private String diagnostico;
    private LocalDateTime dataFimOrdemServico;

    public HistoricoEquipamentoResponse(OrdemServico ordemServico) {
        this.protocolo = ordemServico.getIdOrdemServico();
        this.equipamento = ordemServico.getEquipamento().getPatrimonio();
        this.dataOrdemServico = ordemServico.getDataOrdemServico();
        this.diagnostico = ordemServico.getDiagnostico();
        this.dataFimOrdemServico = ordemServico.getDataFimOrdemServico();
    }

    public static List<HistoricoEquipamentoResponse> converte(List<OrdemServico> ordemServicoList) {
        return ordemServicoList.stream().map(HistoricoEquipamentoResponse::new).collect(Collectors.toList());
    }
}
