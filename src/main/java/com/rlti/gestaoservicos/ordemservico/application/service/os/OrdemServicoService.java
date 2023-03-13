package com.rlti.gestaoservicos.ordemservico.application.service.os;

import com.rlti.gestaoservicos.ordemservico.application.api.os.*;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;

import java.util.List;
import java.util.UUID;

public interface OrdemServicoService {
    OrdemServicoIdResponse criaOSEquipamento(OrdemServicoResquest ordemServicoResquest);
    OrdemServico getOSById(UUID idOrdemServico);
    OrdemServico getOSByIdEquipamento(Long idEquipamento);
    List<OrdemServicoListResponse> getAllOS();
    List<OrdemServicoListResponse> getAtendimentos();
    void alteraOS(UUID idOrdemServico, OrdemServicoAlteracaoRequest ordemServicoAlteracaoRequest);
    void deleta(UUID idOrdemServico);
    OrdemServicoIdResponse criaOs(OrdemServicoResquest ordemServicoResquest);
}