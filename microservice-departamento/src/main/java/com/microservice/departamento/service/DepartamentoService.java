package com.microservice.departamento.service;

import com.microservice.departamento.entities.Departamento;
import com.microservice.departamento.persistence.DepartamentoRepository;
import com.microservice.departamento.dto.DepartamentoDTO;
import com.microservice.empleado.dto.EmpleadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartamentoService implements IDepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private RestTemplate restTemplate;  // Para llamadas HTTP a otros microservicios

    @Override
    public List<Departamento> findAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento findById(Long id) {
        return departamentoRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Departamento departamento) {
        departamentoRepository.save(departamento);
    }

    @Override
    public void deleteById(Long id) {
        departamentoRepository.deleteById(id);
    }

    @Override
    public List<DepartamentoDTO> findAllWithEmpleados() {
        List<Departamento> departamentos = departamentoRepository.findAll();

        return departamentos.stream().map(departamento -> {
            DepartamentoDTO departamentoDTO = new DepartamentoDTO();
            departamentoDTO.setId(departamento.getId());
            departamentoDTO.setNombre(departamento.getNombre());
            departamentoDTO.setDescripcion(departamento.getDescripcion());

            // Llamada HTTP para obtener los empleados asociados al departamento
            String url = "http://localhost:8081/empleado/departamento/" + departamento.getId();
            List<EmpleadoDTO> empleados = restTemplate.getForObject(url, List.class);
            departamentoDTO.setEmpleados(empleados);

            return departamentoDTO;
        }).collect(Collectors.toList());
    }
}
