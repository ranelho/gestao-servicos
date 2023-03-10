package com.rlti.gestaoservicos.usuario.domain;

import com.rlti.gestaoservicos.usuario.application.api.request.RoleRuquest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20, unique = true)
	private ERole name;

	public Role(RoleRuquest roleRuquest) {
		this.name = roleRuquest.getName();
	}
}