package com.microservice.empleado.client;

import com.microservice.empleado.dto.RecursoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-recurso", url = "http://localhost:8083")
public interface RecursoClient {

    @GetMapping("/recurso/by-empleado/{empleadoId}")
    List<RecursoDTO> getRecursosByEmpleadoId(@PathVariable("empleadoId") Long empleadoId);
}
