package com.rlti.gestaoservicos.ordemservico.application.api.os;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.ordemservico.domain.Servico;
import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import com.rlti.gestaoservicos.suporte.application.api.SuporteResponse;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static com.rlti.gestaoservicos.suporte.application.api.SuporteResponse.converte;

@Value
public class OrdemServicoResponse {
    private UUID idOrdemServico;
    private String equipamento;
    private String setor;
    private List<SuporteResponse> suportes;
    private String descricaoProblema;
    private String observacao;
    private LocalDateTime dataOrdemServico;
    private LocalDateTime dataFimOrdemServico;
    private String diagnostico;
    private Situacao situacao;
    private List<Servico> servicos;

    public OrdemServicoResponse(OrdemServico ordemServico) {
        this.idOrdemServico = ordemServico.getIdOrdemServico();
        if(ordemServico.getEquipamento() == null){
            this.equipamento = "Os Externa";
            this.setor = ordemServico.getSetor().getSetor();
        }else {
            this.equipamento = ordemServico.getEquipamento().getPatrimonio();
            this.setor = ordemServico.getEquipamento().getSetor().getSetor();
        }
        this.suportes = converte(ordemServico.getSuportes());
        this.descricaoProblema = ordemServico.getDescricaoProblema();
        this.observacao = ordemServico.getObservacao();
        this.dataFimOrdemServico = ordemServico.getDataFimOrdemServico();
        this.situacao = ordemServico.getSituacao();
        this.diagnostico = ordemServico.getDiagnostico();
        this.servicos = ordemServico.getServicos();
        this.dataOrdemServico = ordemServico.getDataOrdemServico();
    }
}
