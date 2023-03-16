package com.rlti.gestaoservicos.contato.application.service;

import com.rlti.gestaoservicos.contato.application.api.ContatoRequest;
import com.rlti.gestaoservicos.contato.application.api.ContatoResponse;
import com.rlti.gestaoservicos.contato.application.repository.ContatoRepository;
import com.rlti.gestaoservicos.contato.domain.Contato;
import com.rlti.gestaoservicos.equipamento.application.repository.EquipamentoRepository;
import com.rlti.gestaoservicos.usuario.application.repository.UserRepository;
import com.rlti.gestaoservicos.usuario.application.service.UserApplicationService;
import com.rlti.gestaoservicos.usuario.application.service.UserService;
import com.rlti.gestaoservicos.usuario.domain.User;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Log4j2
public class ContatoApplicationService implements ContatoService {

    private final ContatoRepository contatoRepository;
    private final UserService userService;

    @Override
    public ContatoResponse novoContato(UUID userId, ContatoRequest contatoRequest) {
        log.info("[inicia] ContatoRestController - novoContato");
        User user = userService.findById(userId);
        Contato contato = contatoRepository.salva(new Contato(contatoRequest, user));
        log.info("[finaliza] ContatoRestController - novoContato");
        return new ContatoResponse(contato);
    }
}
