package com.clinica.odontologica.controller;


import com.clinica.odontologica.exceptions.ResourceNotFoundException;
import com.clinica.odontologica.model.Paciente;
import com.clinica.odontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin("*")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    /**-------PostMapping sirve para crear un Paciente----------*/
    @PostMapping()
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente) {

        return ResponseEntity.ok(pacienteService.guardar(paciente));

    }

    /**-------GetMapping sirve para leer un solo paciente----------*/
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> obtener(@PathVariable Integer id) {
        Paciente paciente = pacienteService.obtener(id);

        return ResponseEntity.ok(paciente);
    }

    /**-------PutMapping sirve para actualizar un  paciente----------*/
    @PutMapping()
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) {
        ResponseEntity<Paciente> response;

        if (paciente.getId() != null)
            response = ResponseEntity.ok(pacienteService.actualizar(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    /**-------DeleteMapping sirve para eliminar un  paciente----------*/
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) throws ResourceNotFoundException {
        pacienteService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");

    }
    /**-------GetMapping en este caso me lista una lista de  pacientes----------*/
    @GetMapping
    public ResponseEntity<List<Paciente>> obtenerTodos(){
        return ResponseEntity.ok(pacienteService.obtenerTodos());
    }

}
