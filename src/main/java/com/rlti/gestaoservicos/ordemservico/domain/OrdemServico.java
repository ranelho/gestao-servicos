package com.rlti.gestaoservicos.ordemservico.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoAlteracaoRequest;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoResquest;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import com.rlti.gestaoservicos.suporte.domain.Suporte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
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
            name = "ordem_servico_suporte",
            joinColumns = @JoinColumn(name = "idOrdemServico"),
            inverseJoinColumns = @JoinColumn(name = "idSuporte")
    )
    private List<Suporte> suportes;

    @NotNull
    private String descricaoProblema;
    private String observacao;
    private String diagnostico;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ordemServico")
    @JsonIgnore
    private List<Servico> servicos;

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public OrdemServico(OrdemServicoResquest ordemServicoResquest) {
        this.setor = ordemServicoResquest.getSetor();
        this.dataInicial = LocalDate.now();
        this.suportes = ordemServicoResquest.getSuportes();
        this.descricaoProblema = ordemServicoResquest.getDescricaoProblema().toUpperCase();
        this.observacao = ordemServicoResquest.getObservacao().toUpperCase();
        this.situacao = Situacao.AGUARDANDO_ATENDIMENTO;
    }

    public OrdemServico(OrdemServicoResquest ordemServicoResquest, Equipamento equipamento) {
        this.equipamento = equipamento;
        this.dataInicial = LocalDate.now();
        this.suportes = ordemServicoResquest.getSuportes();
        this.descricaoProblema = ordemServicoResquest.getDescricaoProblema().toUpperCase();
        this.observacao = ordemServicoResquest.getObservacao().toUpperCase();
        this.situacao = Situacao.AGUARDANDO_ATENDIMENTO;
    }

    public void altera(OrdemServicoAlteracaoRequest ordemServicoAlteracaoRequest) {
        this.dataFinal = ordemServicoAlteracaoRequest.getDataFinal();
        this.suportes = ordemServicoAlteracaoRequest.getSuportes();
        this.descricaoProblema = ordemServicoAlteracaoRequest.getDescricaoProblema().toUpperCase();
        this.observacao = ordemServicoAlteracaoRequest.getObservacao().toUpperCase();
        this.diagnostico = ordemServicoAlteracaoRequest.getDiagnostico().toUpperCase();
        this.situacao = ordemServicoAlteracaoRequest.getSituacao();
    }
}

