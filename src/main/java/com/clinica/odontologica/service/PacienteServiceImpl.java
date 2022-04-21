package com.clinica.odontologica.service;

import com.clinica.odontologica.exceptions.ResourceNotFoundException;
import com.clinica.odontologica.model.Paciente;
import com.clinica.odontologica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {
    /**Aca estoy inyectando la dependencia repository*/
    private final PacienteRepository pacienteRepository;
    private DomicilioServiceImpl domicilioService;

    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository, DomicilioServiceImpl domicilioService) {
        this.pacienteRepository = pacienteRepository;
        this.domicilioService = domicilioService;
    }

    @Override
    public List<Paciente> obtenerTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente obtener(Integer id) {
        return pacienteRepository.getById(id);
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        paciente.setDomicilio(domicilioService.guardar(paciente.getDomicilio()));
        return pacienteRepository.save(paciente);

    }

    @Override
    public void eliminar(Integer id) throws ResourceNotFoundException {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        pacienteRepository.save(paciente);
        return paciente;
    }
}
