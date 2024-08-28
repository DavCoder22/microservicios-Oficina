package com.microservice.empleado.client;

import com.microservice.empleado.dto.DepartamentoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "msvc-departamento", url = "http://localhost:8082") // Asegúrate de reemplazar la URL con la dirección correcta del servicio de departamento
public interface DepartamentoClient {

    @GetMapping("/departamento")
    List<DepartamentoDTO> getAllDepartamentos();

    @GetMapping("/departamento/{id}")
    DepartamentoDTO getDepartamentoById(@PathVariable("id") Long id);
}
