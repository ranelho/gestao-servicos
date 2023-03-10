package com.rlti.gestaoservicos.autenticacao.application.api.response;

import com.rlti.gestaoservicos.config.security.services.UserDetailsImpl;
import lombok.Value;

import java.util.UUID;

@Value
public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String refreshToken;
	private UUID id;
	private String username;
	private String email;

	public JwtResponse(String accessToken, UserDetailsImpl userDetails,String refreshToken ) {
		this.token = accessToken;
		this.refreshToken = refreshToken;
		this.id = userDetails.getId();
		this.username = userDetails.getUsername();
		this.email = userDetails.getEmail();
	}
}
