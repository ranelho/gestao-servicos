package com.rlti.gestaoservicos.usuario.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_ROLE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role  implements GrantedAuthority, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID roleid;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private  RoleName roleName;

    @Override
    public String getAuthority() {
        return this.roleName.toString();
    }
}
