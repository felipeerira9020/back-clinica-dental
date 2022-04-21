package com.clinica.odontologica.service;

import com.clinica.odontologica.exceptions.ResourceNotFoundException;
import com.clinica.odontologica.model.Paciente;

import java.util.List;

public interface PacienteService {
    List<Paciente> obtenerTodos();
    Paciente obtener(Integer id);
    Paciente guardar(Paciente paciente);
    void eliminar(Integer id) throws ResourceNotFoundException;
    Paciente actualizar(Paciente paciente);
}