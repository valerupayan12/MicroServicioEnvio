package com.example.MicroEnvio.controller;

import com.example.MicroEnvio.dto.ProveedorDTO;
import com.example.MicroEnvio.service.ProveedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/proveedores")
@RequiredArgsConstructor
public class ProveedorController {

    private final ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<ProveedorDTO.Response>> listarTodos() {
        return ResponseEntity.ok(proveedorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorDTO.Response> buscarPorId(@PathVariable int id) {
        return ResponseEntity.ok(proveedorService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProveedorDTO.Response> crear(@Valid @RequestBody ProveedorDTO.Request request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(proveedorService.crear(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedorDTO.Response> actualizar(@PathVariable int id, @Valid @RequestBody ProveedorDTO.Request request) {
        return ResponseEntity.ok(proveedorService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        proveedorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
