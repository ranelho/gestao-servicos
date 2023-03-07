package com.rlti.gestaoservicos.usuario.infra;

import com.rlti.gestaoservicos.usuario.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface RoleSpingDataJPARepository extends JpaRepository<Role, UUID> {
   @Query(value = "select * from tb_role where role_name = :roleName", nativeQuery = true)
   Optional<Role> findByRoleName(String roleName);
}
