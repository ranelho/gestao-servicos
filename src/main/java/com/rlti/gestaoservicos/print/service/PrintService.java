package com.rlti.gestaoservicos.print.service;

import java.util.UUID;

public interface PrintService {
    String gerarOsBase64(UUID idOs);
}
