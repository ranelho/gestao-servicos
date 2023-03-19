package com.rlti.gestaoservicos.relatorios.application.api;

import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoListResponse;
import com.rlti.gestaoservicos.ordemservico.domain.Situacao;
import com.rlti.gestaoservicos.relatorios.application.api.response.EquipamentosBySituacaoResponse;
import com.rlti.gestaoservicos.relatorios.application.api.response.HistoricoEquipamentoResponse;

import java.time.LocalDate;
import java.util.List;

public interface RelatorioService {
    List<EquipamentosBySituacaoResponse> getAllOSSituacao(Situacao situacao);
    List<HistoricoEquipamentoResponse> getHistoricoEquipamento(String patrimonio);
    List<OrdemServicoListResponse> getOSPeriodo(LocalDate dataInicial, LocalDate dataFinal);
}
