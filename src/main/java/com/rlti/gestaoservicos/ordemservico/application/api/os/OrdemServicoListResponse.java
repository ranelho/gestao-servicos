package com.rlti.gestaoservicos.ordemservico.application.api.os;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class OrdemServicoListResponse {
    private UUID protocolo;
    private String patrimonio;
    private String setor;
    private LocalDate dataIncial;
    private LocalDate dataFinal;
    private Situacao situacao;
    private String diagnostico;

    public OrdemServicoListResponse(OrdemServico ordemServico) {
        this.protocolo = ordemServico.getIdOrdemServico();
        this.patrimonio = (ordemServico.getEquipamento() == null) ? "Os Externa" :
                ordemServico.getEquipamento().getPatrimonio();
        this.setor = (ordemServico.getEquipamento() == null) ? ordemServico.getSetor().getSetor() :
                ordemServico.getEquipamento().getSetor().getSetor();
        this.dataIncial = ordemServico.getDataInicial();
        this.dataFinal = ordemServico.getDataFinal();
        this.situacao = ordemServico.getSituacao();
        this.diagnostico = ordemServico.getDiagnostico();
    }

    public static List<OrdemServicoListResponse> converte(List<OrdemServico> ordemServicoList) {
        return ordemServicoList.stream().map(OrdemServicoListResponse::new).collect(Collectors.toList());
    }

}
