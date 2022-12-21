package com.rlti.gestaoservicos.secretaria.infra.setor;

import com.rlti.gestaoservicos.secretaria.domain.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetorSpringDataJPARepository extends JpaRepository<Setor, Long> {
}
