package com.microservice.departamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients  // Habilita Feign Clients si estás utilizando Feign para llamadas entre microservicios
@SpringBootApplication
public class MicroserviceDepartamentoApplication {  // Cambia el nombre de la clase para reflejar correctamente el microservicio

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDepartamentoApplication.class, args);  // Cambia el nombre de la clase aquí también
    }
}
