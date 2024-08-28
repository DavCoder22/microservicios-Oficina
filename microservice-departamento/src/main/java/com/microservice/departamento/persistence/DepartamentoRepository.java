package com.microservice.departamento.persistence;

import com.microservice.departamento.entities.Departamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento, Long> {
    // Métodos adicionales si son necesarios
    List<Departamento> findByNombre(String nombre);

}
