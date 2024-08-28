package com.microservice.departamento.controller;

import com.microservice.departamento.entities.Departamento;
import com.microservice.departamento.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<Departamento>> getAllDepartamentos() {
        return ResponseEntity.ok(departamentoService.findAll());
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public void crearDepartamento(@RequestBody Departamento departamento) {
        departamentoService.save(departamento);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editarDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
        departamento.setId(id);
        departamentoService.save(departamento);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void eliminarDepartamento(@PathVariable Long id) {
        departamentoService.deleteById(id);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Departamento> buscarDepartamento(@PathVariable Long id) {
        return ResponseEntity.ok(departamentoService.findById(id));
    }

    @GetMapping("/empleados/{departamentoId}")
    public ResponseEntity<?> findEmpleadosByDepartamentoId(@PathVariable Long departamentoId) {
        return ResponseEntity.ok(departamentoService.findEmpleadosByDepartamentoId(departamentoId));
    }
}
