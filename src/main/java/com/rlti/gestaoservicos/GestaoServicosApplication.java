package com.rlti.gestaoservicos;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@Log4j2
@EnableFeignClients
public class GestaoServicosApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestaoServicosApplication.class, args);

	}
}
