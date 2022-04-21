package com.clinica.odontologica.controller;


import com.clinica.odontologica.exceptions.ResourceNotFoundException;
import com.clinica.odontologica.model.Odontologo;
import com.clinica.odontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
@CrossOrigin("*")
public class OdontologoController {

    private final OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }


    /**-------PostMapping sirve para crear un odontologo----------*/
    /**ResponseEntity maneja toda la respuesta HTTP incluyendo el cuerpo, cabecera
     *  y códigos de estado permitiéndonos total libertad de configurar la respuesta
     *  que queremos que se envié desde nuestros endpoints. en esta casi si todo es ok devolveri un status 200*/
    @PostMapping()
    public ResponseEntity<Odontologo> guardar(@RequestBody Odontologo odontologo) {

        return ResponseEntity.ok(odontologoService.guardar(odontologo));

    }
    /**-------GetMapping sirve para leer un solo odontologo----------*/
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> obtener(@PathVariable Integer id) {
        Odontologo odontologo = odontologoService.obtener(id);

        return ResponseEntity.ok(odontologo);
    }

    /**-------PutMapping sirve para actualizar un  odontologo----------*/
    @PutMapping()
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo) {
        ResponseEntity<Odontologo> response;

        if (odontologo.getId() != null)
            response = ResponseEntity.ok(odontologoService.actualizar(odontologo));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    /**-------DeleteMapping sirve para eliminar un  odontologo----------*/
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id)  throws ResourceNotFoundException {
        odontologoService.eliminar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");

    }
    /**-------GetMapping en este caso me lista una lista de  odontologo----------*/
    @GetMapping
    public ResponseEntity<List<Odontologo>> obtenerTodos(){
        return ResponseEntity.ok(odontologoService.obtenerTodos());
    }
}
