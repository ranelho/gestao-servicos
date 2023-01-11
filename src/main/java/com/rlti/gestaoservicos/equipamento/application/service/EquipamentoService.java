package com.rlti.gestaoservicos.equipamento.application.service;

import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoAlteracaoRequest;
import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoIdResponse;
import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoListReponse;
import com.rlti.gestaoservicos.equipamento.application.api.EquipamentoRequest;
import com.rlti.gestaoservicos.equipamento.domain.Equipamento;

import java.util.List;

public interface EquipamentoService {
    EquipamentoIdResponse postEquipamento(EquipamentoRequest equipamentoRequest);
    Equipamento getEquipamentoById(Long idEquipamento);
    Equipamento getEquipamentoByPatrimonio(String patrimonio);
    List<EquipamentoListReponse> getAllEquipamentos();
    void alteraEquipamento(Long idEquipamento, EquipamentoAlteracaoRequest equipamentoAlteracaoRequest);
    void detelaEquipamento(Long idEquipamento);
}
