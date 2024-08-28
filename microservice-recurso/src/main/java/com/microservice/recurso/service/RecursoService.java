package com.microservice.recurso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.recurso.entities.Recurso;
import com.microservice.recurso.persistence.RecursoRepository;

@Service
public class RecursoService {

    @Autowired
    private RecursoRepository recursoRepository;

    public List<Recurso> findAll() {
        return recursoRepository.findAll();
    }

    public Recurso findById(Long id) {
        return recursoRepository.findById(id).orElse(null);
    }

    public void save(Recurso recurso) {
        recursoRepository.save(recurso);
    }

    public void deleteById(Long id) {
        recursoRepository.deleteById(id);
    }

    public List<Recurso> findRecursosByEmpleadoId(Long empleadoId) {
        // Implementa la lógica para buscar recursos por empleado si corresponde
        return null;
    }
}
