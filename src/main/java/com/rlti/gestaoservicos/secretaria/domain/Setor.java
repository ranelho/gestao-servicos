package com.rlti.gestaoservicos.secretaria.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import com.rlti.gestaoservicos.secretaria.application.api.setor.SetorAlteracaoRequest;
import com.rlti.gestaoservicos.secretaria.application.api.setor.SetorRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSetor;
    @Column(unique = true, updatable = true)
    @NotNull
    private String setor;
    private String responsavel;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "secretaria_id")
    private Secretaria secretaria;

    @JsonIgnore
    @OneToMany(mappedBy="setor", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private List<Equipamento> equipamentos;

    public Setor(Secretaria secretaria, SetorRequest setorRequest) {
        this.setor = setorRequest.getSetor();
        this.responsavel = setorRequest.getResponsavel().toUpperCase();
        this.secretaria = secretaria;
    }

    public void altera(SetorAlteracaoRequest setorAlteracaoRequest) {
        this.setor = setorAlteracaoRequest.getSetor();
        this.responsavel = setorAlteracaoRequest.getResponsavel().toUpperCase();
        this.secretaria = secretaria;
    }
}
