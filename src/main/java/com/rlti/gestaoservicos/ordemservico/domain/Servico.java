package com.rlti.gestaoservicos.ordemservico.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.gestaoservicos.ordemservico.application.api.servico.ServicoAlteracaoRequest;
import com.rlti.gestaoservicos.ordemservico.application.api.servico.ServicoOSExternaRequest;
import com.rlti.gestaoservicos.ordemservico.application.api.servico.ServicoRequest;
import com.rlti.gestaoservicos.ordemservicoexterna.domain.OrdemServicoExterna;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idServico;
    @NotNull
    private LocalDate dataServico;
    @NotNull
    private String descricaoServico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordem_servico_id")
    @JsonIgnore
    private OrdemServico ordemServico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordemservico_externa_id")
    @JsonIgnore
    private OrdemServicoExterna ordemServicoExterna;

    public Servico(ServicoRequest servicoRequest) {
        this.ordemServico = servicoRequest.getOrdemServico();
        this.dataServico = servicoRequest.getDataServico();
        this.descricaoServico = servicoRequest.getDescricaoServico();
    }

    public Servico(ServicoOSExternaRequest servicoRequest) {
        this.ordemServicoExterna = servicoRequest.getOrdemServicoExterna();
        this.dataServico = servicoRequest.getDataServico();
        this.descricaoServico = servicoRequest.getDescricaoServico();
    }

    public void altera(ServicoAlteracaoRequest servicoAlteracaoRequest){
        this.dataServico = servicoAlteracaoRequest.getDataServico();
        this.descricaoServico = servicoAlteracaoRequest.getDescricaoServico();
    }
}
