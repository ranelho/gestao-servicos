package com.rlti.gestaoservicos.ordemservico.application.service.servico;

import com.rlti.gestaoservicos.ordemservico.application.api.servico.*;
import com.rlti.gestaoservicos.ordemservico.domain.Servico;

import java.util.List;

public interface ServicoService {
    ServicoIdResponse criaServico(ServicoRequest servicoRequest);
    Servico findServicoById(Long idServico);
    List<ServicoListResponse> getAllServicos();
    void alteraServico(Long idServico, ServicoAlteracaoRequest servicoAlteracaoRequest);
    void deletaServicoById(Long idServico);
}
