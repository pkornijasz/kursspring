package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Repository
public class DBKnightRepository implements KnightRepository {
    @Override
    public void createKnight(String name, int age) {
        System.out.println("Używam bazy danych");
    }

    @Override
    public Collection<Knight> getAllKnights() {
        System.out.println("Używam bazy danych");
        return null;
    }

    @Override
    public Knight getKnight(String name) {
        System.out.println("Używam bazy danych");
        return null;
    }

    @Override
    public void deleteKnight(String name) {
        System.out.println("Używam bazy danych");
    }

    @Override
    @PostConstruct
    public void build() {

    }
}
