package com.example.demo;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DateTimeService {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // O retorno deste método fica salvo na memória no cache "current-time"
    @Cacheable("current-time")
    public String getCachedDateTime() {
        return LocalDateTime.now().format(FORMATTER);
    }

    public String getLiveDateTime() {
        return LocalDateTime.now().format(FORMATTER);
    }

    // Endpoint auxiliar para limpar o cache quando necessário
    @CacheEvict(value = "current-time", allEntries = true)
    public void clearCache() {
    }
}