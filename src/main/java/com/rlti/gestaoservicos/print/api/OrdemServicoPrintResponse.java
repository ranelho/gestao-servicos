package com.rlti.gestaoservicos.print.api;

import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import com.rlti.gestaoservicos.suporte.application.api.SuporteResponse;
import lombok.Data;

import java.util.List;
import java.util.UUID;

import static com.rlti.gestaoservicos.suporte.application.api.SuporteResponse.converte;
import static com.rlti.gestaoservicos.util.Utils.formatarData;

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
    String equipamento;
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
        Equipamento equip = ordemServico.getEquipamento();

        if (equip != null) {
            StringBuilder descricaoEquipamento = new StringBuilder();

            descricaoEquipamento.append(equip.getTipoEquipamento().name())
                    .append(" de patrimônio: ")
                    .append(equip.getPatrimonio());

            if (!equip.getMarca().isEmpty())
                descricaoEquipamento.append(", marca: ").append(equip.getMarca());
            if (!equip.getNumeroSerie().isEmpty())
                descricaoEquipamento.append(", serial: ").append(equip.getNumeroSerie());
            if (!equip.getModelo().isEmpty())
                descricaoEquipamento.append(", modelo: ").append(equip.getModelo());

            this.equipamento = descricaoEquipamento.toString();
        } else {
            this.equipamento = "";
        }
        this.diagnostico = ordemServico.getDiagnostico() != null ? "<b>DIAGNÓSTICO:</b> " + ordemServico.getDiagnostico() : "";
        this.dataInicial = formatarData(ordemServico.getDataInicial());
        this.dataEntrega = formatarData(ordemServico.getDataEntrega());
        this.servicos = ServicoPrintResponse.converte(ordemServico.getServicos());
    }
}
