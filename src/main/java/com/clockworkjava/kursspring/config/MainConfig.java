package com.clockworkjava.kursspring.config;

import com.clockworkjava.kursspring.domain.repository.DBKnightRepository;
import com.clockworkjava.kursspring.domain.repository.InMemoryRepository;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@Configuration
public class MainConfig {

//    @Bean(name = "inMemoryRepository")
    @Profile("dev")
    public KnightRepository createInMemoryKnightRepo() {
        KnightRepository repo = new InMemoryRepository();
        return repo;
    }

//    @Bean(name = "DBKnightRepository")
    @Profile("prod")
    public KnightRepository createDBKnightRepo() {
        KnightRepository repo = new DBKnightRepository();
        return repo;
    }

}
