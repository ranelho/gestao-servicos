package com.rlti.gestaoservicos;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@Log4j2
public class GestaoServicosApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestaoServicosApplication.class, args);

		//log.info("{}", new BCryptPasswordEncoder().encode("senha123"));
	}
}
