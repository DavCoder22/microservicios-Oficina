package com.microservice.recurso.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.recurso.entities.Recurso;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Long> {
    // Si tienes métodos adicionales, decláralos aquí
}
