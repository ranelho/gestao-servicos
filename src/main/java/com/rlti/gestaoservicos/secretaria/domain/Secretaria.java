package com.rlti.gestaoservicos.secretaria.domain;

import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaAlteracaoRequest;
import com.rlti.gestaoservicos.secretaria.application.api.secretaria.SecretariaRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Secretaria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSecretaria;
    @NotNull
    @NotBlank(message = "{secretaria.not.blank}")
    @Column(unique = true, updatable = true)
    private String secretaria;
    private String secretario;
    @OneToMany(mappedBy="secretaria", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private List<Setor> setores;

    public Secretaria(SecretariaRequest secretariaRequest) {
        this.secretaria = secretariaRequest.getSecretaria();
        this.secretario = secretariaRequest.getSecretario();
    }
    public void altera(SecretariaAlteracaoRequest secretariaAlteracaoRequestRequest) {
        this.secretaria = secretariaAlteracaoRequestRequest.getSecretaria();
        this.secretario = secretariaAlteracaoRequestRequest.getSecretario();
    }
}
