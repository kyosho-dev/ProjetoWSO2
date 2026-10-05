package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Libera para todos os endpoints da API
                .allowedOriginPatterns("*") // Permite requisições de qualquer origem (inclusive localhost e WSO2)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH") // Métodos HTTP permitidos
                .allowedHeaders("*") // Permite todos os cabeçalhos (Authorization, Content-Type, etc.)
                .allowCredentials(true) // Permite o envio de credenciais/cookies se necessário
                .maxAge(3600); // Tempo em segundos de cache do preflight (OPTIONS)
    }
}