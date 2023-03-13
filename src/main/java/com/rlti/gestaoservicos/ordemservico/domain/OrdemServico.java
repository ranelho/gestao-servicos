package com.rlti.gestaoservicos.ordemservico.domain;

import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoAlteracaoRequest;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoResquest;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import com.rlti.gestaoservicos.suporte.domain.Suporte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idOrdemServico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;

    @ManyToOne
    @JoinColumn(name = "setor_id_setor")
    private Setor setor;

    @NotNull
    @Column(name = "dataInicial", columnDefinition = "TIMESTAMP")
    private LocalDate dataInicial;
    @Column(name = "dataFinal", columnDefinition = "TIMESTAMP")
    private LocalDate dataFinal;
    @NotNull

    @ManyToMany
    @JoinTable(
            name = "ordemservico_suporte",
            joinColumns = @JoinColumn(name = "ordemservico_id"),
            inverseJoinColumns = @JoinColumn(name = "suporte_id")
    )
    private List<Suporte> suportes;

    @NotNull
    private String descricaoProblema;
    private String observacao;
    private String diagnostico;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Servico> servicos;

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public OrdemServico(OrdemServicoResquest ordemServicoResquest) {
        this.setor = ordemServicoResquest.getSetor();
        this.dataInicial = LocalDate.now();
        this.suportes = ordemServicoResquest.getSuportes();
        this.descricaoProblema = ordemServicoResquest.getDescricaoProblema();
        this.observacao = ordemServicoResquest.getObservacao();
        this.situacao = Situacao.AGUARDANDO_ATENDIMENTO;
    }

    public OrdemServico(OrdemServicoResquest ordemServicoResquest, Equipamento equipamento) {
        this.equipamento = equipamento;
        this.dataInicial = LocalDate.now();
        this.suportes = ordemServicoResquest.getSuportes();
        this.descricaoProblema = ordemServicoResquest.getDescricaoProblema();
        this.observacao = ordemServicoResquest.getObservacao();
        this.situacao = Situacao.AGUARDANDO_ATENDIMENTO;
    }

    public void altera(OrdemServicoAlteracaoRequest ordemServicoAlteracaoRequest) {
        this.dataFinal = ordemServicoAlteracaoRequest.getDataFinal();
        this.suportes = ordemServicoAlteracaoRequest.getSuportes();
        this.descricaoProblema = ordemServicoAlteracaoRequest.getDescricaoProblema();
        this.observacao = ordemServicoAlteracaoRequest.getObservacao();
        this.diagnostico = ordemServicoAlteracaoRequest.getDiagnostico();
        this.situacao = ordemServicoAlteracaoRequest.getSituacao();
    }
}

