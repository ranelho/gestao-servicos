package com.rlti.gestaoservicos.contato.application.repository;

import com.rlti.gestaoservicos.contato.domain.Contato;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@Log4j2
public class ContatoInfraRepository implements ContatoRepository {

    private final ContatoSpringDataJPARepository contatoSpringDataJPARepository;

    @Override
    public Contato salva(Contato contato) {
        log.info("[inicia] ContatoInfraRepository - salva");
        contatoSpringDataJPARepository.save(contato);
        log.info("[finaliza] ContatoInfraRepository - salva");
        return contato;
    }
}
