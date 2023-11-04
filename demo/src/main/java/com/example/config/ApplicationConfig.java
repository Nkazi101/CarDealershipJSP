package com.example.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.persistence.Entity;

@Configuration
@EntityScan(basePackages = "com.example.model")
@EnableJpaRepositories(basePackages = "com.example.repository")
public class ApplicationConfig {
    
}
