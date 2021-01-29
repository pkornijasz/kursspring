package com.clockworkjava.kursspring.services;

import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestService {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    final static Random rand = new Random();

    public void assignRandomQuest(String knightName) {
        List<Quest> allQuests = questRepository.getAll();
        Quest randomQuest = allQuests.get(rand.nextInt(allQuests.size()));
        knightRepository.getKnight(knightName).setQuest(randomQuest);
        questRepository.deleteQuest(randomQuest);
    }
}
