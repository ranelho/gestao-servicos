package com.rlti.gestaoservicos.ordemservico.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.gestaoservicos.ordemservico.application.api.servico.ServicoAlteracaoRequest;
import com.rlti.gestaoservicos.ordemservico.application.api.servico.ServicoRequest;
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

    public Servico(ServicoRequest servicoRequest, OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
        this.dataServico = servicoRequest.getDataServico();
        this.descricaoServico = servicoRequest.getDescricaoServico().toUpperCase();
    }

    public void altera(ServicoAlteracaoRequest servicoAlteracaoRequest){
        this.dataServico = servicoAlteracaoRequest.getDataServico();
        this.descricaoServico = servicoAlteracaoRequest.getDescricaoServico().toUpperCase();
    }
}
