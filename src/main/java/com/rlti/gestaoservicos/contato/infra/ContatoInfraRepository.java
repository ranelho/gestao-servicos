package com.rlti.gestaoservicos.contato.infra;

import com.rlti.gestaoservicos.contato.application.repository.ContatoRepository;
import com.rlti.gestaoservicos.contato.domain.Contato;
import com.rlti.gestaoservicos.handler.APIException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Contato findContato(UUID userId) {
        log.info("[inicia] ContatoInfraRepository - findContato");
        Optional<Contato> optionalContato = contatoSpringDataJPARepository.findContatoByUserUserId(userId);
        Contato contato = optionalContato
                .orElseThrow(
                    () -> { throw APIException.build(HttpStatus.NOT_FOUND, "contato inexistente!");
                }
        );
        log.info("[finaliza] ContatoInfraRepository - findContato");
        return contato;
    }

    @Override
    public List<Contato> getAllNome(String nomeCompleto) {
        List<Contato> contatos = contatoSpringDataJPARepository.findByNomeCompletoContaining(nomeCompleto);
        return contatos;

    }
}
