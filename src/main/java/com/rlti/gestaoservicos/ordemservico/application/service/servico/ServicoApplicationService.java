package com.rlti.gestaoservicos.ordemservico.application.service.servico;

import com.rlti.gestaoservicos.ordemservico.application.api.servico.ServicoAlteracaoRequest;
import com.rlti.gestaoservicos.ordemservico.application.api.servico.ServicoIdResponse;
import com.rlti.gestaoservicos.ordemservico.application.api.servico.ServicoListResponse;
import com.rlti.gestaoservicos.ordemservico.application.api.servico.ServicoRequest;
import com.rlti.gestaoservicos.ordemservico.application.repository.servico.ServicoRepository;
import com.rlti.gestaoservicos.ordemservico.domain.Servico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ServicoApplicationService implements ServicoService {

    private final ServicoRepository servicoRepository;
    @Override
    public ServicoIdResponse criaServico(ServicoRequest servicoRequest) {
        log.info("[inicia] ServicoApplicationService - criaSecretaria");
        Servico servico = servicoRepository.salva(new Servico(servicoRequest));
        log.info("[finaliza] ServicoApplicationService - criaSecretaria");
        return ServicoIdResponse.builder().idServico(servico.getIdServico()).build();
    }

    @Override
    public Servico buscaServicoPorId(Long idServico) {
        log.info("[inicia] ServicoApplicationService - buscaSecretariaPorId");
        Servico servico = servicoRepository.buscaServicoPorId(idServico);
        log.info("[finaliza] ServicoApplicationService - buscaSecretariaPorId");
        return servico;
    }

    @Override
    public List<ServicoListResponse> getTodosServicos() {
        log.info("[inicia] ServicoApplicationService - getTodasServicos");
        List<Servico> listaServico = servicoRepository.getTodosServicos();
        log.info("[finaliza] ServicoApplicationService - getTodasServicos");
        return ServicoListResponse.converte(listaServico);
    }

    @Override
    public void alteraServico(Long idServico, ServicoAlteracaoRequest servicoAlteracaoRequest) {
        log.info("[inicia] ServicoApplicationService - alteraSecretaria");
        Servico servico = servicoRepository.buscaServicoPorId(idServico);
        servico.altera(servicoAlteracaoRequest);
        servicoRepository.salva(servico);
        log.info("[finaliza] ServicoApplicationService - alteraSecretaria");
    }

    @Override
    public void deletaServicoPorId(Long idServico) {
        log.info("[inicia] ServicoApplicationService - deletaServicoPorId");
        buscaServicoPorId(idServico);
        servicoRepository.deleta(idServico);
        log.info("[finaliza] ServicoApplicationService - deletaServicoPorId");
    }
}
