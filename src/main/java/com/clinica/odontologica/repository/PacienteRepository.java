package com.clinica.odontologica.repository;


import com.clinica.odontologica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}

