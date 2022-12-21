package com.rlti.gestaoservicos.secretaria.domain;

import com.rlti.gestaoservicos.secretaria.application.api.setor.SetorAlteracaoRequest;
import com.rlti.gestaoservicos.secretaria.application.api.setor.SetorRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSetor;
    @NotNull
    @NotBlank(message = "{setor.not.blank}")
    private String setor;
    private String responsavel;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "secretaria_id")
    private Secretaria secretaria;

    public Setor(Secretaria secretaria, SetorRequest setorRequest) {
        this.setor = setorRequest.getSetor();
        this.responsavel = setorRequest.getResponsavel();
        this.secretaria = secretaria;
    }

    public void altera(SetorAlteracaoRequest setorAlteracaoRequest) {
        this.setor = setorAlteracaoRequest.getSetor();
        this.responsavel = setorAlteracaoRequest.getResponsavel();
        this.secretaria = secretaria;
    }
}
