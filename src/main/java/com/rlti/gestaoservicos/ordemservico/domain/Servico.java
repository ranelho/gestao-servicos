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
    private String descricaoServico;
    @ManyToOne
    private OrdemServico ordemServico;


    public Servico(ServicoRequest servicoRequest) {
        this.dataServico = servicoRequest.getDataServico();
        this.descricaoServico = servicoRequest.getDescricaoServico();
      //  this.ordemServico = servicoRequest.getOrdemServico();
    }

    public void altera(ServicoAlteracaoRequest servicoAlteracaoRequest){
        this.dataServico = servicoAlteracaoRequest.getDataServico();
        this.descricaoServico = servicoAlteracaoRequest.getDescricaoServico();
    }
}
