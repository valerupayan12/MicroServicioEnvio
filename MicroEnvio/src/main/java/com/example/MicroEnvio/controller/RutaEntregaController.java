package com.example.MicroEnvio.controller;

import com.example.MicroEnvio.dto.RutaEntregaDTO;
import com.example.MicroEnvio.service.RutaEntregaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rutas")
@RequiredArgsConstructor
public class RutaEntregaController {

    private final RutaEntregaService rutaEntregaService;

    @GetMapping
    public ResponseEntity<List<RutaEntregaDTO.Response>> listarTodos() {
        return ResponseEntity.ok(rutaEntregaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutaEntregaDTO.Response> buscarPorId(@PathVariable int id) {
        return ResponseEntity.ok(rutaEntregaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<RutaEntregaDTO.Response> crear(@Valid @RequestBody RutaEntregaDTO.Request request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rutaEntregaService.crear(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RutaEntregaDTO.Response> actualizar(@PathVariable int id, @Valid @RequestBody RutaEntregaDTO.Request request) {
        return ResponseEntity.ok(rutaEntregaService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        rutaEntregaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
