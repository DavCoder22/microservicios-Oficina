package com.microservice.empleado.dto;

import lombok.Data;
import java.util.List;

@Data
public class DepartamentoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private List<EmpleadoDTO> empleados; // Lista de empleados en el departamento
}
