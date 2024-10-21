package com.rlti.gestaoservicos.secretaria.application.api.setor;

import com.rlti.gestaoservicos.secretaria.application.service.setor.SetorService;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import com.rlti.gestaoservicos.secretaria.domain.Setor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class SetorRestController implements SetorApi{
    private final SetorService setorService;

    @Override
    public SetorIdResponse postSetor(SetorRequest setorRequest, Long secretaria) {
        log.info("[inicia] SetorRestController - postSetor");
        SetorIdResponse setorIdResponse = setorService.postSetor(secretaria, setorRequest);
        log.info("[finaliza] SetorRestController - postSetor");
        return setorIdResponse;
    }

    @Override
    public SetorDetalhadoResponse getSetorById(Long idSetor) {
        log.info("[inicia] SetorRestController - getSetorById");
        Setor setor = setorService.getSetorById(idSetor);
        log.info("[finaliza] SetorRestController - getSetorById");
        return new SetorDetalhadoResponse(setor);
    }

    @Override
    public List<SetorListResponse> getAllSetores() {
        log.info("[inicia] SetorRestController - getAllSetores");
        List<SetorListResponse> listaSetores = setorService.getAllSetores();
        log.info("[finaliza] SetorRestController - getAllSetores");
        return listaSetores;
    }

    @Override
    public void alteraSetor(Long idSetor, SetorAlteracaoRequest setorAlteracaoRequest) {
        log.info("[inicia] SetorRestController - alteraSetor");
        setorService.alteraSetor(idSetor, setorAlteracaoRequest);
        log.info("[finaliza] SetorRestController - alteraSetor");
    }

    @Override
    public void deletaSetorById(Long idSetor) {
        log.info("[inicia] SetorRestController - deletaSetorById");
        setorService.deletaSetor(idSetor);
        log.info("[finaliza] SetorRestController - deletaSetorById");
    }
}
