package com.rlti.gestaoservicos.ordemservico.domain;

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
    private String servico;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordem_servico_id")
    private OrdemServico ordemServico;

    public Servico(ServicoRequest servicoRequest) {
        this.dataServico = servicoRequest.getDataServico();
        this.servico = servicoRequest.getServico();
        this.ordemServico = servicoRequest.getOrdemServico();
    }

    public void altera(ServicoAlteracaoRequest servicoAlteracaoRequest){
        this.dataServico = servicoAlteracaoRequest.getDataServico();
        this.servico = servicoAlteracaoRequest.getServico();
    }
}
