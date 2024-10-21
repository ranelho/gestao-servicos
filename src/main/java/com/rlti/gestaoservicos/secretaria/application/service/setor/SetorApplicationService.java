package com.rlti.gestaoservicos.secretaria.application.service.setor;

import com.rlti.gestaoservicos.secretaria.application.api.setor.SetorAlteracaoRequest;
import com.rlti.gestaoservicos.secretaria.application.api.setor.SetorIdResponse;
import com.rlti.gestaoservicos.secretaria.application.api.setor.SetorListResponse;
import com.rlti.gestaoservicos.secretaria.application.api.setor.SetorRequest;
import com.rlti.gestaoservicos.secretaria.application.repository.secretaria.SecretariaRepository;
import com.rlti.gestaoservicos.secretaria.application.repository.setor.SetorRepository;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class SetorApplicationService implements SetorService {

    private final SetorRepository setorRepository;
    private final SecretariaRepository secretariaRepository;

    @Override
    public SetorIdResponse postSetor(Long idSecretaria, SetorRequest setorRequest) {
        log.info("[inicia] SetorApplicationService - postSetor");
        Secretaria secretaria = secretariaRepository.findSecretariaById(idSecretaria);
        Setor setor = setorRepository.salva(new Setor(secretaria, setorRequest));
        log.info("[finaliza] SetorApplicationService - postSetor");
        return SetorIdResponse.builder().idSetor(setor.getIdSetor()).build();
    }

    @Override
    public Setor getSetorById(Long idSetor) {
        log.info("[inicia] SetorApplicationService - getSetorById");
        Setor setor = setorRepository.findSetorById(idSetor);
        log.info("[finaliza] SetorApplicationService - getSetorById");
        return setor;
    }

    @Override
    public List<SetorListResponse> getAllSetores() {
        log.info("[inicia] SetorApplicationService - getAllSetores");
        List<Setor> listaSetor = setorRepository.findSetores();
        log.info("[finaliza] SetorApplicationService - getAllSetores");
        return SetorListResponse.converte(listaSetor);
    }

    @Override
    public void alteraSetor(Long idSetor, SetorAlteracaoRequest setorAlteracaoRequest) {
        log.info("[inicia] SetorApplicationService - alteraSetor");
        Setor setor = setorRepository.findSetorById(idSetor);
        setor.altera(setorAlteracaoRequest);
        setorRepository.salva(setor);
        log.info("[finaliza] SetorApplicationService - alteraSetor");
    }

    @Override
    public void deletaSetor(Long idSetor) {
        log.info("[inicia] SetorApplicationService - deletaSetor");
        getSetorById(idSetor);
        setorRepository.deleta(idSetor);
        log.info("[finaliza] SetorApplicationService - deletaSetor");
    }
}
