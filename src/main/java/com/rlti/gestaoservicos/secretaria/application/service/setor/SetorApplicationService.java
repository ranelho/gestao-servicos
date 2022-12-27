package com.rlti.gestaoservicos.secretaria.application.service.setor;

import com.rlti.gestaoservicos.handler.APIException;
import com.rlti.gestaoservicos.secretaria.application.api.setor.*;
import com.rlti.gestaoservicos.secretaria.application.repository.secretaria.SecretariaRepository;
import com.rlti.gestaoservicos.secretaria.application.repository.setor.SetorRepository;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class SetorApplicationService implements SetorService {

    private final SetorRepository setorRepository;
    @Override
    public SetorIdResponse postSetor(Secretaria secretaria, SetorRequest setorRequest) {
        log.info("[inicia] SetorApplicationService - postSetor");
        Setor setor = setorRepository.salva(new Setor(secretaria, setorRequest));
        log.info("[finaliza] SetorApplicationService - postSetor");
        return SetorIdResponse.builder().idSetor(setor.getIdSetor()).build();
    }

    @Override
    public Setor getSetorPorId(Long idSetor) {
        log.info("[inicia] SetorApplicationService - getSetorPorId");
        Setor setor = setorRepository.buscaSetorPorId(idSetor);
        log.info("[finaliza] SetorApplicationService - getSetorPorId");
        return setor;
    }

    @Override
    public List<SetorListResponse> getTodosSetores() {
        log.info("[inicia] SetorApplicationService - getTodosSetores");
        List<Setor> listaSetor = setorRepository.buscaSetores();
        log.info("[finzaliza] SetorApplicationService - getTodosSetores");
        return SetorListResponse.converte(listaSetor);
    }

    @Override
    public void alteraSetor(Long idSetor, SetorAlteracaoRequest setorAlteracaoRequest) {
        log.info("[inicia] SetorApplicationService - alteraSetor");
        Setor setor = setorRepository.buscaSetorPorId(idSetor);
        setor.altera(setorAlteracaoRequest);
        setorRepository.salva(setor);
        log.info("[finaliza] SetorApplicationService - alteraSetor");
    }

    @Override
    public void deletaSetor(Long idSetor) {
        log.info("[inicia] SetorApplicationService - deletaSetor");
        getSetorPorId(idSetor);
        setorRepository.deleta(idSetor);
        log.info("[finaliza] SetorApplicationService - deletaSetor");
    }
}
