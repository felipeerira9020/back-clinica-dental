package com.clinica.odontologica.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
 // transmitir información entre un cliente y un servido crear vistas
//Los DTO son un tipo de objetos que sirven únicamente para transportar datos.
//EL DTO contiene las propiedades del objeto. Datos que pueden tener su origen en una o más entidades de información.
public class OdontologoDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String matricula;
}
