package com.rlti.gestaoservicos.ordemservico.application.api.os;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.ordemservico.domain.Servico;
import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import com.rlti.gestaoservicos.suporte.application.api.SuporteResponse;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static com.rlti.gestaoservicos.suporte.application.api.SuporteResponse.converte;

@Value
public class OrdemServicoResponse {
    UUID protocolo;
    String patrimonio;
    String setor;
    List<SuporteResponse> suportes;
    String descricaoProblema;
    String observacao;
    LocalDate dataInicial;
    LocalDate dataFinal;
    String diagnostico;
    Situacao situacao;
    List<Servico> servicos;

    public OrdemServicoResponse(OrdemServico ordemServico) {
        this.protocolo = ordemServico.getIdOrdemServico();
        this.patrimonio = (ordemServico.getEquipamento() == null) ? "Os Externa" :
                ordemServico.getEquipamento().getPatrimonio();
        this.setor = (ordemServico.getEquipamento() == null) ? ordemServico.getSetor().getSetor() :
                ordemServico.getEquipamento().getSetor().getSetor();
        this.suportes = converte(ordemServico.getSuportes());
        this.descricaoProblema = ordemServico.getDescricaoProblema();
        this.observacao = ordemServico.getObservacao();
        this.dataFinal = ordemServico.getDataFinal();
        this.situacao = ordemServico.getSituacao();
        this.diagnostico = ordemServico.getDiagnostico();
        this.servicos = ordemServico.getServicos();
        this.dataInicial = ordemServico.getDataInicial();
    }
}