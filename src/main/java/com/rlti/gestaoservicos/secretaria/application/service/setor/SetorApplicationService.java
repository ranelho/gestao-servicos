package com.rlti.gestaoservicos.secretaria.application.service.setor;

import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.secretaria.application.api.setor.SetorDetalhadoResponse;
import com.rlti.gestaoservicos.secretaria.application.api.setor.SetorIdResponse;
import com.rlti.gestaoservicos.secretaria.application.api.setor.SetorRequest;
import com.rlti.gestaoservicos.secretaria.application.repository.secretaria.SecretariaRepository;
import com.rlti.gestaoservicos.secretaria.application.repository.setor.SetorRepository;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class SetorApplicationService implements SetorService {

    private final SetorRepository setorRepository;
    @Override
    public SetorIdResponse postSetor(Secretaria secretaria, SetorRequest setorRequest) {
        log.info("[inicia] SecretariaInfraRepository - postSetor");
        Setor setor = setorRepository.salva(new Setor(secretaria, setorRequest));
        log.info("[finaliza] SecretariaInfraRepository - postSetor");
        return SetorIdResponse.builder().idSetor(setor.getIdSetor()).build();
    }

    @Override
    public Setor getSetorPorId(Long idSetor) {
        log.info("[inicia] SecretariaInfraRepository - getSetorPorId");
        Setor setor = setorRepository.buscaSetorPorId(idSetor)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Setor não encontrada!"));
        log.info("[finaliza] SecretariaInfraRepository - getSetorPorId");
        return setor;
    }
}
