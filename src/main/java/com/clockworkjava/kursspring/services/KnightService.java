package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.repository.PlayerInformationRepository;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

@Component
public class KnightService {

    final KnightRepository knightRepository;

    final PlayerInformationRepository playerInformation;

    final QuestRepository questRepository;

    public KnightService(KnightRepository knightRepository, PlayerInformationRepository playerInformation, QuestRepository questRepository) {
        this.knightRepository = knightRepository;
        this.playerInformation = playerInformation;
        this.questRepository = questRepository;
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

        Predicate<Knight> knightPredicate = knight -> {
            if (knight.getQuest() != null) {
                return knight.getQuest().isCompleted();
            } else {
                return false;
            }
        };

        int sum = knightRepository.getAllKnights().stream().filter(knightPredicate)
                .mapToInt(knight -> knight.getQuest().getReward()).sum();

        knightRepository.getAllKnights().stream()
                .filter(knightPredicate)
                .forEach(knight -> {
                    knight.setQuest(null);
                });
        return sum;
    }

    @Transactional
    public void getMyGold() {
        List<Knight> allKnights = getAllKnights();
        allKnights.forEach(knight -> {
                    if (knight.getQuest() != null) {
                        boolean completed = knight.getQuest().isCompleted();
                        if (completed) {
                            questRepository.update(knight.getQuest());
                        }
                    }
                }
        );
        PlayerInformation first = playerInformation.getFirst();
        int currentGold = first.getGold();
        first.setGold(currentGold + collectRewards());
    }

}
