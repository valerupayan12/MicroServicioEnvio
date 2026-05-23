package com.example.MicroEnvio.service;

import com.example.MicroEnvio.dto.ComunaDTO;
import java.util.List;

public interface ComunaService {
    List<ComunaDTO.Response> listarTodos();
    ComunaDTO.Response buscarPorId(int id);
    ComunaDTO.Response crear(ComunaDTO.Request request);
    ComunaDTO.Response actualizar(int id, ComunaDTO.Request request);
    void eliminar(int id);
}
