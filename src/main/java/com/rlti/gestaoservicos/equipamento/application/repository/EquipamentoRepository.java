package com.rlti.gestaoservicos.equipamento.application.repository;

import com.rlti.gestaoservicos.equipamento.domain.Equipamento;

import java.util.List;
import java.util.Optional;

public interface EquipamentoRepository {
    Equipamento salva(Equipamento equipamento);
    Equipamento findEquipamentoById(Long idEquipamento);
    Optional<Equipamento> findEquipamentoByPatrimonio(String patrimonio);
    List<Equipamento> buscaEquipamentos();
    void deleta(Long idEquipamento);
}
