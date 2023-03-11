package com.rlti.gestaoservicos.relatorios.application.api;

import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import com.rlti.gestaoservicos.relatorios.application.api.response.EquipamentosPendentesResponse;
import com.rlti.gestaoservicos.relatorios.application.api.response.HistoricoEquipamentoResponse;

import java.util.List;

public interface RelatorioService {
    List<EquipamentosPendentesResponse> getAllOSSituacao(Situacao situacao);
    List<HistoricoEquipamentoResponse> getHistoricoEquipamento(String patrimonio);
}
