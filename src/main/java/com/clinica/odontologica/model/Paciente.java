package com.clinica.odontologica.model;


import com.clinica.odontologica.util.Util;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@ToString
/**me crea un contructor con todo menos con el id por que el se crea autoincremental en la bd*/
@AllArgsConstructor
/**me crea un contructor vacio*/
@NoArgsConstructor
public class Paciente {
    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;

    @OneToOne(cascade = CascadeType.ALL)
    /** @JoinColumn En una relación, @OneToOne puede utilizarse para indicar que una columna en la entidad padre
    se referencia a una clave primaria en la entidad hijo.
    Por ejemplo, Paciente se relaciona con domicilio a través de una clave foránea, que es domicilio:id.*/
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"paciente"})
/**   Trae los turnos asociados al paciente*/
    private Set<Turno> turnos;


}
