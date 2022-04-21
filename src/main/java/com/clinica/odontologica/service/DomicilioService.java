package com.clinica.odontologica.service;

import com.clinica.odontologica.model.Domicilio;

import java.util.List;
import java.util.Optional;

public interface DomicilioService {
    List<Domicilio> obtenerTodos();
    Optional<Domicilio> obtener(Integer id);
    Domicilio guardar(Domicilio domicilio);
    void eliminar(Integer id);
}