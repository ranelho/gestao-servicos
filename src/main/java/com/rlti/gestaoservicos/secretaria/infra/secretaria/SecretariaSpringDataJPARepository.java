package com.rlti.gestaoservicos.secretaria.infra.secretaria;

import com.rlti.gestaoservicos.secretaria.domain.Secretaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecretariaSpringDataJPARepository extends JpaRepository<Secretaria, Long> {
}
