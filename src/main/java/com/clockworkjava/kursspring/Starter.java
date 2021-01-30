package com.clockworkjava.kursspring;

import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import com.clockworkjava.kursspring.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    private KnightRepository knightRepository;

    @Autowired
    private QuestRepository questRepository;

    @Autowired
    private QuestService questService;

    @Override
    public void run(String... args) throws Exception {
        questRepository.createRandomQuest();
        questRepository.createRandomQuest();

        questService.assignRandomQuest("Percival");
    }
}
