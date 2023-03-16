package com.rlti.gestaoservicos.equipamento.application.api;

import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import com.rlti.gestaoservicos.equipamento.domain.TipoEquipamento;
import lombok.Value;

@Value
public class EquipamentoReponse {
    Long idEquipamento;
    String patrimonio;
    TipoEquipamento tipoEquipamento;
    String numeroSerie;
    String modelo;
    String marca;
    String detalhes;

    public EquipamentoReponse(Equipamento equipamento) {
        this.idEquipamento = equipamento.getIdEquipamento();
        this.patrimonio = equipamento.getPatrimonio();
        this.tipoEquipamento = equipamento.getTipoEquipamento();
        this.numeroSerie = equipamento.getNumeroSerie();
        this.modelo = equipamento.getModelo();
        this.marca = equipamento.getMarca();
        this.detalhes = equipamento.getDetalhes();
    }
}
