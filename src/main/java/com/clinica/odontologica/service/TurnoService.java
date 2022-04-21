package com.clinica.odontologica.service;

import com.clinica.odontologica.exceptions.BadRequestException;
import com.clinica.odontologica.exceptions.ResourceNotFoundException;
import com.clinica.odontologica.model.TurnoDTO;

import java.util.Collection;

public interface TurnoService {
    Collection<TurnoDTO> obtenerTodos();
    TurnoDTO obtener(Integer id);
    void guardar(TurnoDTO turnoDTO) throws BadRequestException;
    void eliminar(Integer id) throws ResourceNotFoundException;
    void actualizar(TurnoDTO turnoDTO);
}