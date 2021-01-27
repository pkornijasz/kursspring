package com.clockworkjava.kursspring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@PropertySource("classpath:castle.properties")
@PropertySource("castle.properties")
public class Castle {
    @Value("${my.castle.name:East Watch}")
    private String name;// = "East Watch";

//    @Autowired
    Knight knight;

    public Castle() {
    }

    @Autowired
    public Castle(Knight knight) {
        this.knight = knight;
    }

    Castle(Knight knight, String name) {
        this.name = name;
        this.knight = knight;
    }

    @PostConstruct
    public void build() {
        System.out.println("Wybudowano zamek " + name + ".");
    }

    @PreDestroy
    public void tearDown() {
        System.out.println("Zaraz wyburzymy zamek " + name + ".");
    }

    @Override
    public String toString() {
        return "Znajduje się tu zamek o nazwie " + name + ". Zamieszkały przez rycerza " + knight;
    }
}
