package com.rlti.gestaoservicos.suporte.domain;

import com.rlti.gestaoservicos.suporte.application.api.SuporteAlteracaoRequest;
import com.rlti.gestaoservicos.suporte.application.api.SuporteRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Suporte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSuporte;
    @NotNull
    @Column(unique = true, updatable = true)
    private String nome;
    private String empresa;

    public Suporte(SuporteRequest suporteRequest) {
        this.nome = suporteRequest.getNome();
        this.empresa = suporteRequest.getEmpresa();
    }

    public void altera(SuporteAlteracaoRequest suporteAlteracaoRequest) {
        this.nome = suporteAlteracaoRequest.getNome();
        this.empresa = suporteAlteracaoRequest.getEmpresa();
    }
}
