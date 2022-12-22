package com.rlti.gestaoservicos.suporte.application.repository;

import com.rlti.gestaoservicos.suporte.domain.Suporte;

import java.util.List;
import java.util.Optional;

public interface SuporteRepository {
    Suporte salva(Suporte suporte);
    Optional<Suporte> buscaSuportePorId(Long idSuporte);
    List<Suporte> getTodosSuportes();
    void deleta(Long idSuporte);
}