package com.rlti.gestaoservicos.suporte.infra;

import com.rlti.gestaoservicos.suporte.domain.Suporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuporteSpringDataJPARepository extends JpaRepository<Suporte, Long> {
}
