package com.clockworkjava.kursspring.config;

import com.clockworkjava.kursspring.domain.repository.DBKnightRepository;
import com.clockworkjava.kursspring.domain.repository.InMemoryRepository;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import org.springframework.context.annotation.*;

@Configuration
public class MainConfig {

    @Primary
    @Profile("dev")
    public KnightRepository createInMemoryKnightRepo() {
        KnightRepository repo = new InMemoryRepository();
        return repo;
    }

    @Profile("prod")
    public KnightRepository createDBKnightRepo() {
        KnightRepository repo = new DBKnightRepository();
        return repo;
    }

}
