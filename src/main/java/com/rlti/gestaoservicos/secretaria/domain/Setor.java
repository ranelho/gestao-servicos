package com.rlti.gestaoservicos.secretaria.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSetor;
    private String setor;
    @ManyToOne
    @JoinColumn(name = "secretaria_id")
    private Secretaria secretaria;
}
