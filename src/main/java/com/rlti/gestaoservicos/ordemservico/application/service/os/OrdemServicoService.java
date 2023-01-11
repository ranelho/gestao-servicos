package com.rlti.gestaoservicos.ordemservico.application.service.os;

import com.rlti.gestaoservicos.ordemservico.application.api.os.*;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;

import java.util.List;

public interface OrdemServicoService {
    OrdemServicoIdResponse criaOS(OrdemServicoResquest ordemServicoResquest);
    OrdemServico getOSPorId(Long idOrdemServico);
    OrdemServico getOSPorIdEquipamento(Long idEquipamento);
    List<OrdemServicoListResponse> getTodosOS();
    void alteraOS(Long idOrdemServico, OrdemServicoAlteracaoRequest ordemServicoAlteracaoRequest);
    void deleta(Long idOrdemServico);

    List<OrdemServicoListResponse> getAtendimentos();
}
