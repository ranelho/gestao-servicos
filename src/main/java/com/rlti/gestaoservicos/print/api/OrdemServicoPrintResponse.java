package com.rlti.gestaoservicos.print.api;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import com.rlti.gestaoservicos.suporte.application.api.SuporteResponse;
import com.rlti.gestaoservicos.util.Utils;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static com.rlti.gestaoservicos.suporte.application.api.SuporteResponse.converte;
import static com.rlti.gestaoservicos.util.Utils.*;

@Data
public class OrdemServicoPrintResponse {
    UUID protocolo;
    String patrimonio;
    String setor;
    String responsavel;
    List<SuporteResponse> suportes;
    String descricaoProblema;
    String observacao;
    String dataInicial;
    String dataFinal;
    String dataEntrega;
    String diagnostico;
    Situacao situacao;
    private List<ServicoPrintResponse> servicos;

    public OrdemServicoPrintResponse(OrdemServico ordemServico) {
        this.protocolo = ordemServico.getIdOrdemServico();
        this.patrimonio = (ordemServico.getEquipamento() == null) ? "Os Externa" :
                ordemServico.getEquipamento().getPatrimonio();
        this.setor = (ordemServico.getEquipamento() == null) ? ordemServico.getSetor().getSetor() :
                ordemServico.getEquipamento().getSetor().getSetor();
        this.responsavel = ordemServico.getSetor().getResponsavel().toUpperCase();
        this.suportes = converte(ordemServico.getSuportes());
        this.descricaoProblema = ordemServico.getDescricaoProblema();
        this.observacao = ordemServico.getObservacao();
        this.dataFinal = formatarData(ordemServico.getDataFinal());
        this.situacao = ordemServico.getSituacao();
        this.diagnostico = ordemServico.getDiagnostico();
        this.dataInicial = formatarData(ordemServico.getDataInicial());
        this.dataEntrega = formatarData(ordemServico.getDataEntrega());
        this.servicos = ServicoPrintResponse.converte(ordemServico.getServicos());
    }
}
