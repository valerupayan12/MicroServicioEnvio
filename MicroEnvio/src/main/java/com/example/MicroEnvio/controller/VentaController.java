package com.example.MicroEnvio.controller;

import com.example.MicroEnvio.dto.VentaDTO;
import com.example.MicroEnvio.service.VentaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ventas")
@RequiredArgsConstructor
public class VentaController {

    private final VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<VentaDTO.Response>> listarTodos() {
        return ResponseEntity.ok(ventaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaDTO.Response> buscarPorId(@PathVariable int id) {
        return ResponseEntity.ok(ventaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<VentaDTO.Response> crear(@Valid @RequestBody VentaDTO.Request request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.crear(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaDTO.Response> actualizar(@PathVariable int id, @Valid @RequestBody VentaDTO.Request request) {
        return ResponseEntity.ok(ventaService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        ventaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
