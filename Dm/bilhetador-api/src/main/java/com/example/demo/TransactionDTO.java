package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDTO {
    public record BilheteRequest(String idChamada, String numeroOrigem, String numeroDestino, Integer duracaoSegundos,
            BigDecimal valorPorMinuto) {

    }

    public record BilheteResponse(String idTransacao, String idChamada, BigDecimal valorTotal,
            LocalDateTime dataProcessamento, String status) {

    }
}
