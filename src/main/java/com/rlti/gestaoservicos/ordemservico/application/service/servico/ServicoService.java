package com.rlti.gestaoservicos.ordemservico.application.service.servico;

import com.rlti.gestaoservicos.ordemservico.application.api.servico.*;
import com.rlti.gestaoservicos.ordemservico.domain.Servico;

import java.util.List;
import java.util.UUID;

public interface ServicoService {
    ServicoIdResponse criaServico(UUID idOrdemServico, ServicoRequest servicoRequest);
    Servico findServicoById(Long idServico);
    List<ServicoListResponse> getAllServicos();
    void alteraServico(Long idServico, ServicoAlteracaoRequest servicoAlteracaoRequest);
    void deletaServicoById(Long idServico);
}
