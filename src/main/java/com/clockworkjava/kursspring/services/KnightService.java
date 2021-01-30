package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class KnightService {

    final KnightRepository knightRepository;

    public KnightService(KnightRepository knightRepository) {
        this.knightRepository = knightRepository;
    }

    public List<Knight> getAllKnights() {
        return new ArrayList<>(knightRepository.getAllKnights());
    }

    public void saveKnight(Knight knight) {
        knightRepository.createKnight(knight.getName(), knight.getAge());
    }

    public Knight getKnight(Integer id) {
        return knightRepository.getKnightById(id);
    }

    public void deleteKnight(Integer id) {
        knightRepository.deleteKnight(id);
    }

    public void updateKnight(Knight knight) {
        knightRepository.updateKnight(knight.getId(), knight);
    }

    public int collectRewards() {
        int sum = knightRepository.getAllKnights().stream()
                .filter(knight -> knight.getQuest().isCompleted())
                .mapToInt(knight -> knight.getQuest().getReward())
                .sum();
        knightRepository.getAllKnights().stream()
                .filter(knight -> knight.getQuest().isCompleted())
                .forEach(knight -> {
                    knight.setQuest(null);
                });
        return sum;
    }
}
