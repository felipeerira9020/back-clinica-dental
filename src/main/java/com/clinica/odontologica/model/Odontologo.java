package com.clinica.odontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Entity se usa para  etiquetar a la clase como un Bean(objeto que maneja el contenedor de spring boot)
 * del tipo entity que va a ser mapeado por el ORM con una tabla de la BD.
 */
@Entity

/** @Table Especifica detalles de la tabla que va a ser
usada para persistir la entidad en la B no es necesariio el atributo name ya que la clase se llama igual a la tabla*/
@Table
/**@Data me trae ya los getter setter , constructores y equals entonces me evito dar @Setter @Getter etc.*/
@Data


public class Odontologo {
    /**
     * @Id Es la la primary key permite que la BD genere un nuevo
     * valor con cada operación de inserción. 1 2 3 etc
     */
    @Id
    @SequenceGenerator(name = "odontologo_sequence", sequenceName = "odontologo_sequence", allocationSize = 1)

    /**@GeneratedValue es el responsable de generar los campos del id  y el SEQUENCE asigna claves primarias para las
     * entidades utilizando una secuencia que puede ser modificable.
     * */
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_sequence")
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer matricula;

    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"odontologo"})
    private Set<Turno> turnos;



}
