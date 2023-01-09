package com.rlti.gestaoservicos.ordemservico.application.service.os;

import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoAlteracaoRequest;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoIdResponse;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoListResponse;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoResquest;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;

import java.util.List;

public interface OrdemServicoService {
    OrdemServicoIdResponse criaOS(OrdemServicoResquest ordemServicoResquest);
    OrdemServico getOSPorId(Long idOrdemServico);
    List<OrdemServicoListResponse> getTodosOS();
    void alteraOS(Long idOrdemServico, OrdemServicoAlteracaoRequest ordemServicoAlteracaoRequest);
    void deleta(Long idOrdemServico);
    List<OrdemServicoListResponse> getAtendimentos();
}
