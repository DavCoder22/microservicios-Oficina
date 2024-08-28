package com.microservice.empleado.service;

import java.util.List;

import com.microservice.empleado.entities.Empleado;
import com.microservice.empleado.http.response.OrderByEmpleadoResponse;
import com.microservice.empleado.http.response.ReviewByEmpleadoResponse;

public interface IEmpleadoService {

    List<Empleado> findAll(); // Cambiado a findAll para seguir la convención con la entidad Empleado
    Empleado findById(Long id); // Cambiado a findById para trabajar con la entidad Empleado
    void save(Empleado empleado); // Cambiado a save para aceptar la entidad Empleado
    void deleteById(Long id); // Cambiado a deleteById para reflejar la acción en la entidad Empleado
    ReviewByEmpleadoResponse findReviewByEmpleadoId(Long empleadoId); // Cambiado para que coincida con Empleado
    OrderByEmpleadoResponse findOrderByEmpleadoId(Long empleadoId); // Cambiado para que coincida con Empleado

}
