package com.clinica.odontologica.service;

import com.clinica.odontologica.exceptions.ResourceNotFoundException;
import com.clinica.odontologica.model.Odontologo;
import com.clinica.odontologica.repository.OdontologoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoServiceImpl implements OdontologoService {

    final static Logger log = Logger.getLogger(OdontologoServiceImpl.class);

    private final OdontologoRepository odontologoRepository;


    @Autowired
    public OdontologoServiceImpl(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public List<Odontologo> obtenerTodos() {
        log.debug("Lista de odontologos registrados");
        return odontologoRepository.findAll();
    }

    @Override
    public Odontologo obtener(Integer id) {
        log.debug("Odontologo con id " + id);
        return odontologoRepository.getById(id);
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        log.debug("Registrando  odontologo con id: " + odontologo.getId());
        return odontologoRepository.save(odontologo);
    }

    @Override
    public void eliminar(Integer id) throws ResourceNotFoundException {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }
}
