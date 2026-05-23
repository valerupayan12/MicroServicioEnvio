package com.example.MicroEnvio.controller;

import com.example.MicroEnvio.dto.ComunaDTO;
import com.example.MicroEnvio.service.ComunaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comunas")
@RequiredArgsConstructor
public class ComunaController {

    private final ComunaService comunaService;

    @GetMapping
    public ResponseEntity<List<ComunaDTO.Response>> listarTodos() {
        return ResponseEntity.ok(comunaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComunaDTO.Response> buscarPorId(@PathVariable int id) {
        return ResponseEntity.ok(comunaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ComunaDTO.Response> crear(@Valid @RequestBody ComunaDTO.Request request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(comunaService.crear(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComunaDTO.Response> actualizar(@PathVariable int id, @Valid @RequestBody ComunaDTO.Request request) {
        return ResponseEntity.ok(comunaService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        comunaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
