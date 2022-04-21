package com.clinica.odontologica.service;

import com.clinica.odontologica.model.Domicilio;
import com.clinica.odontologica.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/** @Service Sirve para indicar que una clase pertenece a la capa de negocio, es decir, donde codificamos la lógica de negocios de nuestra
 aplicación y ocultamos la complejidad de la misma al resto de las capas es decir de DomicilioService*/
@Service
public class DomicilioServiceImpl implements DomicilioService{
    private final DomicilioRepository domicilioRepository;

    /**@Autowired permite inyectar unas dependencias con otras, en lugar de un costructor o getter y setter
     * spring lo hace asi */
    @Autowired
    public DomicilioServiceImpl(DomicilioRepository domicilioRepository){this.domicilioRepository = domicilioRepository;}

    @Override
    public List<Domicilio> obtenerTodos() {
        return domicilioRepository.findAll();
    }

    @Override
    public Optional<Domicilio> obtener(Integer id) {
        return domicilioRepository.findById(id);
    }

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }

    @Override
    public void eliminar(Integer id) {
        domicilioRepository.deleteById(id);
    }
}