package com.prestek.notification.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/health")
@Tag(name = "Health Check", description = "API para verificar el estado de salud del servicio de notificaciones")
public class HealthController {

    @GetMapping
    @Operation(
        summary = "Verificar estado de salud del servicio",
        description = "Endpoint que retorna el estado actual del servicio de notificaciones, incluyendo timestamp y versión"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Servicio funcionando correctamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(example = "{\"status\":\"UP\",\"service\":\"notification-service\",\"timestamp\":\"2025-09-22T10:30:00\",\"version\":\"1.0.0\"}")
            )
        )
    })
    public ResponseEntity<Map<String, Object>> health() {
        Map<String, Object> healthStatus = new HashMap<>();
        healthStatus.put("status", "UP");
        healthStatus.put("service", "notification-service");
        healthStatus.put("timestamp", LocalDateTime.now());
        healthStatus.put("version", "1.0.0");
        
        return ResponseEntity.ok(healthStatus);
    }
}