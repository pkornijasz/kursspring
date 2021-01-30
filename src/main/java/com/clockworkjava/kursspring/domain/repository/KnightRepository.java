package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Knight;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Collection;
import java.util.Optional;

public interface KnightRepository {
    void createKnight(String name, int age);

    Collection<Knight> getAllKnights();

    Optional<Knight> getKnight(String name);

    void deleteKnight(Integer id);

    void build();

    void createKnight(Knight knight);

    Knight getKnightById(Integer id);

    void updateKnight(int id, Knight knight);
}
