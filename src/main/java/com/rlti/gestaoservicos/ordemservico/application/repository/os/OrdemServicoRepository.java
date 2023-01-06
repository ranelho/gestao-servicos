package com.rlti.gestaoservicos.ordemservico.application.repository.os;

import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;

import java.util.List;

public interface OrdemServicoRepository {
    OrdemServico salva(OrdemServico ordemServico);
    OrdemServico buscaOSPorId(Long idOrdemServico);
    List<OrdemServico> getTodosOS();
    void deleta(Long idOrdemServico);
}
