package com.microservice.recurso.controller;

import com.microservice.recurso.entities.Recurso;
import com.microservice.recurso.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recurso")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public ResponseEntity<List<Recurso>> getAllRecursos() {
        return ResponseEntity.ok(recursoService.findAll());
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public void crearRecurso(@RequestBody Recurso recurso) {
        recursoService.save(recurso);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editarRecurso(@PathVariable Long id, @RequestBody Recurso recurso) {
        recurso.setId(id);
        recursoService.save(recurso);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarRecurso(@PathVariable Long id) {
        recursoService.deleteById(id);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Recurso> buscarRecurso(@PathVariable Long id) {
        return ResponseEntity.ok(recursoService.findById(id));
    }

    @GetMapping("/empleado/{empleadoId}")
    public ResponseEntity<?> findRecursosByEmpleadoId(@PathVariable Long empleadoId) {
        return ResponseEntity.ok(recursoService.findRecursosByEmpleadoId(empleadoId));
    }
}
