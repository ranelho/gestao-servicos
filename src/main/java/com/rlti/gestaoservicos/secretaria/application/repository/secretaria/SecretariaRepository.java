package com.rlti.gestaoservicos.secretaria.application.repository.secretaria;

import com.rlti.gestaoservicos.secretaria.domain.Secretaria;

import java.util.List;
import java.util.Optional;

public interface SecretariaRepository {
    Secretaria salva(Secretaria secretaria);
    Optional<Secretaria> buscaSecretariaPorId(Long idSecretaria);
    List<Secretaria> getTodasSecretarias();
    void deleta(Long idSecretaria);
}
