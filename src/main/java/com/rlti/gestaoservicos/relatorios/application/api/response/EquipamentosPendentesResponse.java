package com.rlti.gestaoservicos.relatorios.application.api.response;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class EquipamentosPendentesResponse {
    UUID protocolo;
    String equipamento;
    String tipoEquipamento;
    LocalDate dataInicial;
    Situacao situacao;
    String diagnostico;

    public EquipamentosPendentesResponse(OrdemServico ordemServico) {
            this.protocolo = ordemServico.getIdOrdemServico();
            this.tipoEquipamento = String.valueOf(ordemServico.getEquipamento().getTipoEquipamento());
            this.equipamento = ordemServico.getEquipamento().getPatrimonio();
            this.dataInicial = ordemServico.getDataInicial();
            this.situacao = ordemServico.getSituacao();
            this.diagnostico = ordemServico.getDiagnostico();
    }

    public static List<EquipamentosPendentesResponse> converte(List<OrdemServico> ordemServicoList) {
        return ordemServicoList.stream().map(EquipamentosPendentesResponse::new).collect(Collectors.toList());
    }
}