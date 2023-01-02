package com.rlti.gestaoservicos.ordemservico.application.api.servico;

import com.rlti.gestaoservicos.ordemservico.application.service.servico.ServicoService;
import com.rlti.gestaoservicos.ordemservico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ServicoRestController implements ServicoApi {
    private final ServicoService servicoService;

    @Override
    public ServicoIdResponse postServico(ServicoRequest servicoRequest) {
        log.info("[inicia] ServicoRestController - postServico");
        ServicoIdResponse servicoCriado = servicoService.criaServico(servicoRequest);
        log.info("[finaliza] ServicoRestController - postServico");
        return servicoCriado;
    }

    @Override
    public ServicoDetalhadoResponse getServicoPorId(Long idServico) {
        log.info("[inicia] ServicoRestController - getServicoPorId");
        Servico servico = servicoService.buscaServicoPorId(idServico);
        log.info("[finaliza] ServicoRestController - getServicoPorId");
        return new ServicoDetalhadoResponse(servico);
    }

    @Override
    public List<ServicoListResponse> getTodosServicos() {
        log.info("[inicia] ServicoRestController - getTodasSecretarias");
        List<ServicoListResponse> listaServicos = servicoService.getTodosServicos();
        log.info("[finaliza] ServicoRestController - getTodasSecretarias");
        return listaServicos;
    }

    @Override
    public void alteraServico(Long idServico, ServicoAlteracaoRequest servicoAlteracaoRequest) {
        log.info("[inicia] ServicoRestController - alteraServico");
        servicoService.alteraServico(idServico, servicoAlteracaoRequest);
        log.info("[finaliza] ServicoRestController - alteraServico");
    }

    @Override
    public void deletaServicoPorId(Long idServico) {
        log.info("[inicia] ServicoRestController - deletaServicoPorId");
        servicoService.deletaServicoPorId(idServico);
        log.info("[finaliza] ServicoRestController - deletaServicoPorId");
    }
}
