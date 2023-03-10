package com.rlti.gestaoservicos.ordemservico.domain;


import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoAlteracaoRequest;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoResquest;
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
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idOrdemServico;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;
    @NotNull
    @Column(name = "dataOrdemServico", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataOrdemServico;
    @Column(name = "dataFimOrdemServico", columnDefinition = "TIMESTAMP")
    private LocalDateTime dataFimOrdemServico;
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

    public OrdemServico(OrdemServicoResquest ordemServicoResquest) {
        this.equipamento = ordemServicoResquest.getEquipamento();
        this.dataOrdemServico = LocalDateTime.now();
        this.suportes = ordemServicoResquest.getSuportes();
        this.descricaoProblema = ordemServicoResquest.getDescricaoProblema();
        this.observacao = ordemServicoResquest.getObservacao();
        this.situacao = Situacao.AGUARDANDO_ATENDIMENTO;
    }

    public void altera(OrdemServicoAlteracaoRequest ordemServicoAlteracaoRequest) {
        this.dataFimOrdemServico = ordemServicoAlteracaoRequest.getDataFimOrdemServico();
        this.suportes = ordemServicoAlteracaoRequest.getSuportes();
        this.descricaoProblema = ordemServicoAlteracaoRequest.getDescricaoProblema();
        this.observacao = ordemServicoAlteracaoRequest.getObservacao();
        this.diagnostico = ordemServicoAlteracaoRequest.getDiagnostico();
        this.situacao = ordemServicoAlteracaoRequest.getSituacao();
    }
}

