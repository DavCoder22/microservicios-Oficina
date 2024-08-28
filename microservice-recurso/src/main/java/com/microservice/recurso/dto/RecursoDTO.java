package com.microservice.empleado.dto;

import lombok.Data;

@Data
public class RecursoDTO {
    private Long id;
    private String nombre;
    private String marca;
    private String estado;
}
