package com.rlti.gestaoservicos.equipamento.application.service;

import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoIdResponse;
import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoListReponse;
import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoRequest;
import com.rlti.gestaoservicos.equipamento.domain.Equipamento;

import java.util.List;

public interface EquipamentoService {
    EquipamentoIdResponse postEquipamento(EquipamentoRequest equipamentoRequest);
    Equipamento getEquipamentoPorId(Long idEquipamento);
    List<EquipamentoListReponse> getTodosEquipamentos();
}
