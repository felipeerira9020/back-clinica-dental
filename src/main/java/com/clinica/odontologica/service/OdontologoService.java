package com.clinica.odontologica.service;

import com.clinica.odontologica.exceptions.ResourceNotFoundException;
import com.clinica.odontologica.model.Odontologo;

import java.util.List;

public interface OdontologoService {
    List<Odontologo> obtenerTodos();
    Odontologo obtener(Integer id);
    Odontologo guardar(Odontologo odontologo);
    void eliminar(Integer id) throws ResourceNotFoundException;
    Odontologo actualizar(Odontologo odontologo);
}