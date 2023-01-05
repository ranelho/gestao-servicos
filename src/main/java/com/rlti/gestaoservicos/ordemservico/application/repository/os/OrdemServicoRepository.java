package com.rlti.gestaoservicos.ordemservico.application.repository.os;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;

public interface OrdemServicoRepository {
    OrdemServico salva(OrdemServico ordemServico);
    OrdemServico buscaOSPorId(Long idOrdemServico);
}
