package com.rlti.gestaoservicos.suporte.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.suporte.application.api.SuporteAlteracaoRequest;
import com.rlti.gestaoservicos.suporte.application.api.SuporteRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Suporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSuporte;
    @NotBlank
    @Column(unique = true, updatable = true)
    private String nome;
    private String empresa;

    @ManyToMany(mappedBy = "suportes")
    @JsonIgnore
    private List<OrdemServico> ordemServicos;

    public Suporte(SuporteRequest suporteRequest) {
        this.nome = suporteRequest.getNome().toUpperCase();
        this.empresa = suporteRequest.getEmpresa().toUpperCase();
    }

    public void altera(SuporteAlteracaoRequest suporteAlteracaoRequest) {
        this.nome = suporteAlteracaoRequest.getNome().toUpperCase();
        this.empresa = suporteAlteracaoRequest.getEmpresa().toUpperCase();
    }
}