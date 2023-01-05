package com.rlti.gestaoservicos.ordemservico.application.service.os;

import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoIdResponse;
import com.rlti.gestaoservicos.ordemservico.application.api.os.OrdemServicoResquest;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;

public interface OrdemServicoService {
    OrdemServicoIdResponse criaOS(OrdemServicoResquest ordemServicoResquest);
    OrdemServico getOSPorId(Long idOrdemServico);
}
