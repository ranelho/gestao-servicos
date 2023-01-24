package com.rlti.gestaoservicos.ordemservicoexterna.domain;


import com.rlti.gestaoservicos.ordemservico.domain.Servico;
import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import com.rlti.gestaoservicos.ordemservicoexterna.application.api.OrdemServicoExternaAlteracaoRequest;
import com.rlti.gestaoservicos.ordemservicoexterna.application.api.OrdemServicoExternaResquest;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import com.rlti.gestaoservicos.suporte.domain.Suporte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class OrdemServicoExterna {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idOrdemServicoExterna;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "setor_id")
    private Setor setor;
    @NotNull
    @Column(name = "dataOrdemServico", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataOrdemServico;
    @Column(name = "dataFimOrdemServico", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataFimOrdemServico;
    @NotNull
    @ManyToMany
    @JoinTable(
            name = "ordemservico_externa_suporte",
            joinColumns = @JoinColumn(name = "ordemservico_externa_id"),
            inverseJoinColumns = @JoinColumn(name = "suporte_id")
    )
    private List<Suporte> suportes;
    @NotNull
    private String descricaoProblema;
    private String observacao;
    private String diagnostico;
    @NotNull
    private Situacao situacao;
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ordemServicoExterna")
    private List<Servico> servicos;

    public OrdemServicoExterna(OrdemServicoExternaResquest ordemServicoExternaResquest) {
        this.setor = ordemServicoExternaResquest.getSetor();
        this.dataOrdemServico = LocalDateTime.now();
        this.suportes = ordemServicoExternaResquest.getSuportes();
        this.descricaoProblema = ordemServicoExternaResquest.getDescricaoProblema();
        this.observacao = ordemServicoExternaResquest.getObservacao();
        this.situacao = Situacao.AGUARDANDO_ATENDIMENTO;
    }

    public void altera(OrdemServicoExternaAlteracaoRequest ordemServicoExternaAlteracaoRequest) {
        this.dataFimOrdemServico = ordemServicoExternaAlteracaoRequest.getDataFimOrdemServico();
        this.suportes = ordemServicoExternaAlteracaoRequest.getSuportes();
        this.descricaoProblema = ordemServicoExternaAlteracaoRequest.getDescricaoProblema();
        this.observacao = ordemServicoExternaAlteracaoRequest.getObservacao();
        this.diagnostico = ordemServicoExternaAlteracaoRequest.getDiagnostico();
        this.situacao = ordemServicoExternaAlteracaoRequest.getSituacao();
    }
}

