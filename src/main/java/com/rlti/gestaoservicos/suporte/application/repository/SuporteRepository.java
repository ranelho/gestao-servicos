package com.rlti.gestaoservicos.suporte.application.repository;

import com.rlti.gestaoservicos.suporte.domain.Suporte;

import java.util.List;

public interface SuporteRepository {
    Suporte salva(Suporte suporte);
    Suporte findSuporteById(Long idSuporte);
    List<Suporte> getAllSuportes();
    void deleta(Long idSuporte);
}
