package com.rlti.gestaoservicos.config;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "jwtTokenProvider", url = "http://localhost:8000/security/api/auth")
public interface JwtTokenProvider {

    @GetMapping("/validateToken")
    boolean validateToken(@RequestParam("token") String token);
}
