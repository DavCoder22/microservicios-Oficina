package com.microservice.departamento.service;

import com.microservice.departamento.dto.DepartamentoDTO;
import com.microservice.departamento.entities.Departamento;

import java.util.List;

public interface IDepartamentoService {
    List<Departamento> findAllDepartamentos();
    Departamento findById(Long id);
    void save(Departamento departamento);
    void deleteById(Long id);
    List<DepartamentoDTO> findAllWithEmpleados();  // Método para obtener departamentos con empleados asociados
}
