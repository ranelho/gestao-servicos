package com.rlti.gestaoservicos.ordemservicoexterna.application.api;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.ordemservico.domain.Servico;
import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import com.rlti.gestaoservicos.ordemservicoexterna.domain.OrdemServicoExterna;
import com.rlti.gestaoservicos.suporte.application.api.SuporteResponse;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static com.rlti.gestaoservicos.suporte.application.api.SuporteResponse.converte;

@Value
public class OrdemServicoExternaResponse {
    private UUID idOrdemServicoExterna;
    private List<SuporteResponse> suportes;
    private String setor;
    private String descricaoProblema;
    private String observacao;
    private LocalDateTime dataOrdemServico;
    private LocalDateTime dataFimOrdemServico;
    private String diagnostico;
    private Situacao situacao;
    private List<Servico> servicos;

    public OrdemServicoExternaResponse(OrdemServicoExterna ordemServicoExterna) {
        this.idOrdemServicoExterna = ordemServicoExterna.getIdOrdemServicoExterna();
        this.suportes = converte(ordemServicoExterna.getSuportes());
        this.setor = ordemServicoExterna.getSetor().getSetor();
        this.descricaoProblema = ordemServicoExterna.getDescricaoProblema();
        this.observacao = ordemServicoExterna.getObservacao();
        this.dataFimOrdemServico = ordemServicoExterna.getDataFimOrdemServico();
        this.situacao = ordemServicoExterna.getSituacao();
        this.diagnostico = ordemServicoExterna.getDiagnostico();
        this.servicos = ordemServicoExterna.getServicos();
        this.dataOrdemServico = ordemServicoExterna.getDataOrdemServico();
    }
}
