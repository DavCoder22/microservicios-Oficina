package com.microservice.empleado.http.response;

import java.util.List;

import com.microservice.empleado.dto.DepartamentoDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewByEmpleadoResponse {

    private String nombre;

    private String email;

    private List<DepartamentoDTO> departamentoDTOList;
}
