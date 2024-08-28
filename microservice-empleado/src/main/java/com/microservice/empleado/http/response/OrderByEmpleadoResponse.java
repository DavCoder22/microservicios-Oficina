package com.microservice.empleado.http.response;

import java.util.List;

import com.microservice.empleado.dto.RecursoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderByEmpleadoResponse {

    private String nombre;

    private String email;

    private List<RecursoDTO> recursoDTOList;
}
