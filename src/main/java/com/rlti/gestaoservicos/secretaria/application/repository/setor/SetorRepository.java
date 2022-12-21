package com.rlti.gestaoservicos.secretaria.application.repository.setor;

import com.rlti.gestaoservicos.secretaria.domain.Setor;

import java.util.Optional;

public interface SetorRepository {
    Setor salva(Setor setor);
    Optional<Setor> buscaSetorPorId(Long idSetor);
}
