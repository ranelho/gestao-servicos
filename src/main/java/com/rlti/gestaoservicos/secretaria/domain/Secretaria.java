package com.rlti.gestaoservicos.secretaria.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Secretaria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSecretaria;
    @NotNull
    private String secretaria;
    private String secretario;
    @OneToMany(mappedBy="secretaria", cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private Set<Setor> setores;
}
