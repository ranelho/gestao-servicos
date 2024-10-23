package com.rlti.gestaoservicos.ordemservico.infra.servico;

import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.ordemservico.application.repository.servico.ServicoRepository;
import com.rlti.gestaoservicos.ordemservico.domain.Servico;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import com.rlti.gestaoservicos.secretaria.infra.secretaria.SecretariaSpringDataJPARepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ServicoInfraRepository implements ServicoRepository {
    private final ServicoSpringDataJPARepository servicoSpringDataJPARepository;

    @Override
    public Servico salva(Servico servico) {
        log.info("[inicia] ServicoInfraRepository - salva");
        servicoSpringDataJPARepository.save(servico);
        log.info("[finaliza] ServicoInfraRepository - salva");
        return servico;
    }

    @Override
    public Servico findServicoById(Long idServico) {
        log.info("[inicia] ServicoInfraRepository - findServicoById");
        Optional<Servico> optionalServico = servicoSpringDataJPARepository.findById(idServico);
        Servico servico = optionalServico.orElseThrow(
                () -> APIException.build(HttpStatus.NOT_FOUND, "Serviço inexistente!")
        );
        log.info("[finaliza] ServicoInfraRepository - findServicoById");
        return servico;
    }

    @Override
    public List<Servico> getAllServicos() {
        log.info("[inicia] ServicoInfraRepository - getAllServicos");
        List<Servico> listaServicos = servicoSpringDataJPARepository.findAll();
        log.info("[finaliza] ServicoInfraRepository - getAllServicos");
        return listaServicos;
    }

    @Override
    public void deleta(Long idServico) {
        log.info("[inicia] ServicoInfraRepository - deleta");
        servicoSpringDataJPARepository.deleteById(idServico);
        log.info("[finaliza] ServicoInfraRepository - deleta");
    }
}
