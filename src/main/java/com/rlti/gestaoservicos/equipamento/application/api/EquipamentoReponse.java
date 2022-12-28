package com.rlti.gestaoservicos.equipamento.application.api;

import com.rlti.gestaoservicos.equipamento.domain.Equipamento;
import com.rlti.gestaoservicos.equipamento.domain.TipoEquipamento;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import lombok.Value;

@Value
public class EquipamentoReponse {
    private Long idEquipamento;
    private String patrimonio;
    private TipoEquipamento tipoEquipamento;
    private String numeroSerie;
  //  private Setor setor;
    private String modelo;
    private String marca;
    private String detalhes;

    public EquipamentoReponse(Equipamento equipamento) {
        this.idEquipamento = equipamento.getIdEquipamento();
        this.patrimonio = equipamento.getPatrimonio();
        this.tipoEquipamento = equipamento.getTipoEquipamento();
        this.numeroSerie = equipamento.getNumeroSerie();
       // this.setor = equipamento.getSetor();
        this.modelo = equipamento.getModelo();
        this.marca = equipamento.getMarca();
        this.detalhes = equipamento.getDetalhes();
    }
}
