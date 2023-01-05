package com.rlti.gestaoservicos.ordemservico.application.api.os;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.ordemservico.domain.Servico;
import com.rlti.gestaoservicos.suporte.domain.Suporte;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
public class OrdemServicoResponse {
    private String equipamento;
    private List<Suporte> suportes;
    private String descricaoProblema;
    private String observacao;
    private LocalDateTime dataFimOrdemServico;
    private String diagnostico;
    private List<Servico> servicos;

    public OrdemServicoResponse(OrdemServico ordemServico) {
        this.equipamento = ordemServico.getEquipamento().getPatrimonio();
        this.suportes = ordemServico.getSuportes();
        this.descricaoProblema = ordemServico.getDescricaoProblema();
        this.observacao = ordemServico.getObservacao();
        this.dataFimOrdemServico = ordemServico.getDataFimOrdemServico();
        this.diagnostico = ordemServico.getDiagnostico();
        this.servicos = ordemServico.getServicos();
    }
}
