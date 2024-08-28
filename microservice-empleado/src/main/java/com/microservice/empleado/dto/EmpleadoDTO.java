package com.microservice.departamento.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO {
    private Long id;
    private String nombre;
    private String telefono;
    private String direccion;
    private Double sueldo;
    private Long departamentoId;
}
