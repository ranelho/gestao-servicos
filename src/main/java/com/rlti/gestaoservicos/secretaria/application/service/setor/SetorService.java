package com.rlti.gestaoservicos.secretaria.application.service.setor;

import com.rlti.gestaoservicos.secretaria.application.api.setor.*;
import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import com.rlti.gestaoservicos.secretaria.domain.Setor;

import java.util.List;

public interface SetorService {
    SetorIdResponse postSetor(Secretaria secretaria, SetorRequest setorRequest);
    Setor getSetorById(Long idSetor);
    List<SetorListResponse> getAllSetores();
    void alteraSetor(Long idSetor, SetorAlteracaoRequest setorAlteracaoRequest);
    void deletaSetor(Long idSetor);
}
