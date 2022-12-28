package com.rlti.gestaoservicos.equipamento.application.repository;

import com.rlti.gestaoservicos.equipamento.domain.Equipamento;

import java.util.List;

public interface EquipamentoRepository {
    Equipamento salva(Equipamento equipamento);
    Equipamento buscaEquipamentoPorId(Long idEquipamento);
    List<Equipamento> buscaEquipamentos();
}
