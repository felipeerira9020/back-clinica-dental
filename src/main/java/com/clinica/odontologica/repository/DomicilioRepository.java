package com.clinica.odontologica.repository;

import com.clinica.odontologica.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

/**el repository siempre extiende de JpaRepository y recibe la clase con la que vamos a trabajar  y el tipo de dato
 * del id de la clase en este caso el id de Docimicilio en Integer */
public interface DomicilioRepository extends JpaRepository<Domicilio, Integer> {
}
