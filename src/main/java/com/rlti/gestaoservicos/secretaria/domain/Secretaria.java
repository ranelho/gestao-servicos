package com.rlti.gestaoservicos.secretaria.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaAlteracaoRequest;
import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Secretaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSecretaria;
    @NotEmpty
    @Column(unique = true, updatable = true)
    private String secretaria;
    private String secretario;
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "secretaria")
    @JsonIgnore
    private List<Setor> setores;

    public Secretaria(SecretariaRequest secretariaRequest) {
        this.secretaria = secretariaRequest.getSecretaria().toUpperCase();
        this.secretario = secretariaRequest.getSecretario().toUpperCase();
    }
    public void altera(SecretariaAlteracaoRequest secretariaAlteracaoRequestRequest) {
        this.secretaria = secretariaAlteracaoRequestRequest.getSecretaria().toUpperCase();
        this.secretario = secretariaAlteracaoRequestRequest.getSecretario().toUpperCase();
    }
}