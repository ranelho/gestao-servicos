package com.rlti.gestaoservicos.ordemservico.application.service.os;

import com.rlti.gestaoservicos.ordemservico.application.api.os.*;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;

import java.util.List;

public interface OrdemServicoService {
    OrdemServicoIdResponse criaOS(OrdemServicoResquest ordemServicoResquest);
    OrdemServico getOSById(Long idOrdemServico);
    OrdemServico getOSByIdEquipamento(Long idEquipamento);
    List<OrdemServicoListResponse> getAllOS();
    List<OrdemServicoListResponse> getAtendimentos();
    void alteraOS(Long idOrdemServico, OrdemServicoAlteracaoRequest ordemServicoAlteracaoRequest);
    void deleta(Long idOrdemServico);
}