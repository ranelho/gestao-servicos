package com.rlti.gestaoservicos.secretaria.application.repository.setor;

import com.rlti.gestaoservicos.secretaria.domain.Setor;

import java.util.List;

public interface SetorRepository {
    Setor salva(Setor setor);
    Setor findSetorById(Long idSetor);
    List<Setor> findSetores();
    void deleta(Long idSetor);
}
