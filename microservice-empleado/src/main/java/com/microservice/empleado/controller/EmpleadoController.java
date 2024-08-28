package com.microservice.empleado.controller;

import com.microservice.empleado.entities.Empleado;
import com.microservice.empleado.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<?> getAllEmpleados() {
        return ResponseEntity.ok(empleadoService.findAll());
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmpleado(@RequestBody Empleado empleado) {
        empleadoService.save(empleado);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void editEmpleado(@PathVariable Integer id, @RequestBody Empleado empleado) {
        empleado.setId(id);
        empleadoService.save(empleado);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmpleado(@PathVariable Integer id) {
        empleadoService.deleteById(id);
    }

    @GetMapping("/buscar_orden/{empleadoId}")
    public ResponseEntity<?> findOrderByEmpleadoId(@PathVariable Integer empleadoId) {
        // Asumiendo que hay una implementación para este método en el servicio de Empleado
        return ResponseEntity.ok(empleadoService.findOrderByEmpleadoId(empleadoId));
    }

    @GetMapping("/buscar_reseña/{empleadoId}")
    public ResponseEntity<?> findReviewByEmpleadoId(@PathVariable Integer empleadoId) {
        // Asumiendo que hay una implementación para este método en el servicio de Empleado
        return ResponseEntity.ok(empleadoService.findReviewByEmpleadoId(empleadoId));
    }
}
