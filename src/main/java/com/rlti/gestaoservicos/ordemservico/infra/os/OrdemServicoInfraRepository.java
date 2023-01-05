package com.rlti.gestaoservicos.ordemservico.infra.os;

import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.ordemservico.application.repository.os.OrdemServicoRepository;
import com.rlti.gestaoservicos.ordemservico.domain.OrdemServico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Log4j2
@RequiredArgsConstructor
public class OrdemServicoInfraRepository implements OrdemServicoRepository {
    private final OrdemServicoSpringaDataJPARespository ordemServicoSpringaDataJPARespository;
    @Override
    public OrdemServico salva(OrdemServico ordemServico) {
        log.info("[inicia] OrdemServicoInfraRepository - salva");
        try{
            ordemServicoSpringaDataJPARespository.save(ordemServico);
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST, "OS já cadastrada!", e);
        }
        log.info("[finaliza] OrdemServicoInfraRepository - salva");
        return ordemServico;
    }

    @Override
    public OrdemServico buscaOSPorId(Long idOrdemServico) {
        log.info("[inicia] OrdemServicoInfraRepository - buscaOSPorId");
        Optional<OrdemServico> optionalOrdemServico = ordemServicoSpringaDataJPARespository.findById(idOrdemServico);
        OrdemServico ordemServico = optionalOrdemServico
                .orElseThrow(() ->  {
                            throw APIException.build(HttpStatus.NOT_FOUND, "Ordem de Serviço não encontrado");
                        }
                );
        log.info("[finzalia] OrdemServicoInfraRepository - buscaOSPorId");
        return ordemServico;
    }
}
