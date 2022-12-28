package com.rlti.gestaoservicos.equipamento.application.api;

import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import com.rlti.gestaoservicos.equipamento.domain.TipoEquipamento;
import com.rlti.gestaoservicos.secretaria.application.api.setor.SetorListResponse;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class EquipamentoListReponse {
    private Long idEquipamento;
    @NotNull
    private String patrimonio;
    @NotNull
    private TipoEquipamento tipoEquipamento;
    private String numeroSerie;
    private String modelo;
    private String marca;
    @Size(message = "Campo detalhes não pode estar vazio", max = 255, min = 3)
    private String detalhes;

    public static List<EquipamentoListReponse> converte(List<Equipamento> listaEquipamentos) {
        return listaEquipamentos.stream().map(EquipamentoListReponse::new).collect(Collectors.toList());
    }

    public EquipamentoListReponse(Equipamento equipamento) {
        this.idEquipamento = equipamento.getIdEquipamento();
        this.patrimonio = equipamento.getPatrimonio();
        this.tipoEquipamento = equipamento.getTipoEquipamento();
        this.numeroSerie = equipamento.getNumeroSerie();
        this.modelo = equipamento.getModelo();
        this.marca = equipamento.getMarca();
        this.detalhes = equipamento.getDetalhes();
    }
}
