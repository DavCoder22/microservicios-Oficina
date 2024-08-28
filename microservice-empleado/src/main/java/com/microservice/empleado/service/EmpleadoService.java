package com.microservice.empleado.service;

import com.microservice.empleado.client.DepartamentoClient;
import com.microservice.empleado.client.RecursoClient;
import com.microservice.empleado.dto.DepartamentoDTO;
import com.microservice.empleado.dto.EmpleadoDTO;
import com.microservice.empleado.dto.RecursoDTO;
import com.microservice.empleado.entities.Empleado;
import com.microservice.empleado.persistence.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private DepartamentoClient departamentoClient;

    @Autowired
    private RecursoClient recursoClient;

    @Override
    public List<EmpleadoDTO> findAll() {
        List<Empleado> empleados = (List<Empleado>) empleadoRepository.findAll();
        return empleados.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private EmpleadoDTO convertToDTO(Empleado empleado) {
        EmpleadoDTO dto = new EmpleadoDTO();
        dto.setId(empleado.getId());
        dto.setNombre(empleado.getNombre());
        dto.setTelefono(empleado.getTelefono());
        dto.setDireccion(empleado.getDireccion());
        dto.setSueldo(empleado.getSueldo());

        // Obtener el departamento usando FeignClient
        DepartamentoDTO departamento = departamentoClient.getDepartamentoById(empleado.getDepartamentoId());
        dto.setDepartamento(departamento);

        // Obtener recursos asociados usando FeignClient
        List<RecursoDTO> recursos = recursoClient.getRecursosByEmpleadoId(empleado.getId());
        dto.setRecursos(recursos);

        return dto;
    }
}
