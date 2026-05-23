package com.example.MicroEnvio.controller;

import com.example.MicroEnvio.dto.EnvioDTO;
import com.example.MicroEnvio.service.EnvioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/envios")
@RequiredArgsConstructor
public class EnvioController {

    private final EnvioService envioService;

    @GetMapping
    public ResponseEntity<List<EnvioDTO.Response>> listarTodos() {
        return ResponseEntity.ok(envioService.listarTodos());
    }

    @GetMapping("/activos")
    public ResponseEntity<List<EnvioDTO.Response>> listarActivos() {
        return ResponseEntity.ok(envioService.listarActivos());
    }

    @GetMapping("/cliente/{id_cliente}")
    public ResponseEntity<List<EnvioDTO.Response>> listarPorCliente(@PathVariable int id_cliente) {
        return ResponseEntity.ok(envioService.listarPorCliente(id_cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvioDTO.Response> buscarPorId(@PathVariable int id) {
        return ResponseEntity.ok(envioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<EnvioDTO.Response> crear(@Valid @RequestBody EnvioDTO.Request request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(envioService.crear(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvioDTO.Response> actualizar(@PathVariable int id, @Valid @RequestBody EnvioDTO.Request request) {
        return ResponseEntity.ok(envioService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        envioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
