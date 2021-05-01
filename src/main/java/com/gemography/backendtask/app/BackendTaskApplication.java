package com.gemography.backendtask.app;

import com.gemography.backendtask.config.ConfigMarker;
import com.gemography.backendtask.controller.ControllerMarker;
import com.gemography.backendtask.model.DomainMarker;
import com.gemography.backendtask.service.ServiceMarker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {DomainMarker.class, ServiceMarker.class, ControllerMarker.class, ConfigMarker.class})
@SpringBootApplication
public class BackendTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendTaskApplication.class, args);
    }
}
