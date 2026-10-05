package com.example.demo;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/time")
public class DateTimeController {

    private final DateTimeService dateTimeService;

    public DateTimeController(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    // Endpoint COM Cache (Demonstrará o mesmo timestamp fixo)
    @GetMapping("/cached")
    public Map<String, String> getCachedTime() {
        return Map.of(
            "type", "CACHED_RESPONSE",
            "timestamp", dateTimeService.getCachedDateTime()
        );
    }

    // Endpoint SEM Cache (Atualizará os segundos a cada F5)
    @GetMapping("/live")
    public Map<String, String> getLiveTime() {
        return Map.of(
            "type", "REALTIME_RESPONSE",
            "timestamp", dateTimeService.getLiveDateTime()
        );
    }

    // Endpoint para resetar o Cache
    @PostMapping("/clear-cache")
    public Map<String, String> clearCache() {
        dateTimeService.clearCache();
        return Map.of("message", "Cache 'current-time' evicto com sucesso!");
    }
}