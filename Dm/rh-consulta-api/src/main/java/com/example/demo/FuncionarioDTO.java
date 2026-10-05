package com.example.demo;

import java.math.BigDecimal;

public class FuncionarioDTO {
    public record FuncionarioResponse(String matricula, String nome, String cargo, String departamento, BigDecimal salario, Boolean ativo) {

    }
}
