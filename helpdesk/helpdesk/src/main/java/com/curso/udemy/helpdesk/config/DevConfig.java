package com.curso.udemy.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso.udemy.helpdesk.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String valor;

    @Bean
    public boolean instanciaDB() {
        if (valor.equals("create")) {
            this.dbService.instanciaDB();
        }
        return false;
    }

}
