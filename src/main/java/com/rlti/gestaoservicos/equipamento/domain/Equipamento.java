package com.rlti.gestaoservicos.equipamento.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoAlteracaoRequest;
import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoRequest;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipamento;
    @NotBlank
    @Column(nullable = false, unique = true, updatable = true, length = 6)
    private String patrimonio;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoEquipamento tipoEquipamento;
    private String numeroSerie;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "setor_id")
    @JsonIgnore
    private Setor setor;
    private String modelo;
    private String marca;
    private String detalhes;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "equipamento")
    @JsonIgnore
    private List<OrdemServico> ordemServicos;

    public Equipamento(EquipamentoRequest equipamentoRequest) {
        this.patrimonio = equipamentoRequest.getPatrimonio();
        this.tipoEquipamento = equipamentoRequest.getTipoEquipamento();
        this.numeroSerie = equipamentoRequest.getNumeroSerie().toUpperCase();
        this.setor = equipamentoRequest.getSetor();
        this.modelo = equipamentoRequest.getModelo().toUpperCase();
        this.marca = equipamentoRequest.getMarca().toUpperCase();
        this.detalhes = equipamentoRequest.getDetalhes().toUpperCase();
    }
    public void altera(EquipamentoAlteracaoRequest equipamentoAlteracaoRequest) {
        this.patrimonio = equipamentoAlteracaoRequest.getPatrimonio();
        this.tipoEquipamento = equipamentoAlteracaoRequest.getTipoEquipamento();
        this.numeroSerie = equipamentoAlteracaoRequest.getNumeroSerie().toUpperCase();
        this.modelo = equipamentoAlteracaoRequest.getModelo().toUpperCase();
        this.marca = equipamentoAlteracaoRequest.getMarca().toUpperCase();
        this.detalhes = equipamentoAlteracaoRequest.getDetalhes().toUpperCase();
    }
}
