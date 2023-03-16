package com.rlti.gestaoservicos.relatorios.application.api.response;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class HistoricoEquipamentoResponse {

    UUID protocolo;
    String equipamento;
    LocalDate dataIncial;
    String diagnostico;
    LocalDate dataFinal;

    public HistoricoEquipamentoResponse(OrdemServico ordemServico) {
        this.protocolo = ordemServico.getIdOrdemServico();
        this.equipamento = ordemServico.getEquipamento().getPatrimonio();
        this.dataIncial = ordemServico.getDataInicial();
        this.diagnostico = ordemServico.getDiagnostico();
        this.dataFinal = ordemServico.getDataFinal();
    }

    public static List<HistoricoEquipamentoResponse> converte(List<OrdemServico> ordemServicoList) {
        return ordemServicoList.stream().map(HistoricoEquipamentoResponse::new).collect(Collectors.toList());
    }
}